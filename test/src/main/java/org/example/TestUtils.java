package org.example;

import sdl.Texture;
import sdl.render.Renderer;
import sdl.surface.Surface;

public class TestUtils {
    record LoadedTexture(Texture texture, int width, int height) {}
    public static LoadedTexture loadTexture(Renderer renderer, String file, boolean transparent) {
        Surface temp = null;
        Texture texture = null;
        String path;

        path = GetNearbyFilename(file);

        if (path != null) {
            file = path;
        }

        temp = SDL_LoadBMP(file);
        if (temp == NULL) {
            SDL_LogError(SDL_LOG_CATEGORY_APPLICATION, "Couldn't load %s: %s", file, SDL_GetError());
        } else {
            /* Set transparent pixel as the pixel at (0,0) */
            if (transparent) {
                if (temp->format->palette) {
                    SDL_SetColorKey(temp, SDL_TRUE, *(Uint8 *)temp->pixels);
                } else {
                    switch (temp->format->BitsPerPixel) {
                        case 15:
                            SDL_SetColorKey(temp, SDL_TRUE,
                                    (*(Uint16 *)temp->pixels) & 0x00007FFF);
                            break;
                        case 16:
                            SDL_SetColorKey(temp, SDL_TRUE, *(Uint16 *)temp->pixels);
                            break;
                        case 24:
                            SDL_SetColorKey(temp, SDL_TRUE,
                                    (*(Uint32 *)temp->pixels) & 0x00FFFFFF);
                            break;
                        case 32:
                            SDL_SetColorKey(temp, SDL_TRUE, *(Uint32 *)temp->pixels);
                            break;
                    }
                }
            }

            if (width_out != NULL) {
            *width_out = temp->w;
            }

            if (height_out != NULL) {
            *height_out = temp->h;
            }

            texture = renderer.createTexture(temp);
            texture = SDL_CreateTextureFromSurface(renderer, temp);
            if (texture == NULL) {
                SDL_LogError(SDL_LOG_CATEGORY_APPLICATION, "Couldn't create texture: %s\n", SDL_GetError());
            }
        }
        SDL_FreeSurface(temp);
        if (path) {
            SDL_free(path);
        }
        return texture;
    }
}
