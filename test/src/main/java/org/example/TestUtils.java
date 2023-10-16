package org.example;

import sdl.Texture;
import sdl.render.Renderer;
import sdl.surface.Surface;

public class TestUtils {
    public static Texture loadTexture(Renderer renderer, String file, boolean transparent) {
        try (Surface temp = Surface.loadBMP(file)) {
            /* Set transparent pixel as the pixel at (0,0) */
            if (transparent) {
                if (true) {
                    throw new RuntimeException("not yet implemented");
                }
                if (temp.format().palette() != null) {
                    // temp.setColorKey(true, temp.pixels().[0]);
                    //SDL_SetColorKey(temp, SDL_TRUE, *(Uint8 *)temp->pixels);
                } else {
                    //switch (temp.format().BitsPerPixel) {
                    //    case 15:
                    //        //temp.setColorKey(true, ( * (Uint16 *)temp -> pixels) & 0x00007FFF);
                    //        break;
                    //    case 16:
                    //        //SDL_SetColorKey(temp, SDL_TRUE, * (Uint16 *) temp -> pixels);
                    //        break;
                    //    case 24:
                    //        //SDL_SetColorKey(temp, SDL_TRUE,
                    //        //        ( * (Uint32 *)temp -> pixels) & 0x00FFFFFF);
                    //        break;
                    //    case 32:
                    //        // SDL_SetColorKey(temp, SDL_TRUE, * (Uint32 *) temp -> pixels);
                    //        break;
                    //}
                }
            }

            return renderer.createTexture(temp);
        }
    }
}
