package sdl;

import sdl.gamecontroller.GameController;
import sdl.gamecontroller.SensorType;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.List;

import static sdl.jextract.SDL_subset_h.*;

public class TestController {

    private GameController gameController;
    private List<GameController> gameControllers = new ArrayList<>();


    int findController(SDL_JoystickID controller_id)
    {
        int i;

        for (i = 0; i < gameControllers.size(); ++i) {
            if (controller_id == SDL_JoystickInstanceID(SDL_GameControllerGetJoystick(gameControllers.get(i))) {
                return i;
            }
        }
        return -1;
    }

    static String getSensorName(SensorType sensor)
    {
        return switch (sensor) {
            case Accel -> "accelerometer";
            case Gryo -> "gyro";
            case AccelL -> "accelerometer (L)";
            case GyroL -> "gyro (L)";
            case AccelR -> "accelerometer (R)";
            case GyroR -> "gyro (R)";
            default -> "UNKNOWN";
        };
    }

    static void AddController(int device_index, boolean verbose)
    {
        SDL_JoystickID controller_id = SDL_JoystickGetDeviceInstanceID(device_index);
        SDL_GameController *controller;
        SDL_GameController **controllers;
        Uint16 firmware_version;
        SDL_SensorType sensors[] = {
                SDL_SENSOR_ACCEL,
                SDL_SENSOR_GYRO,
                SDL_SENSOR_ACCEL_L,
                SDL_SENSOR_GYRO_L,
                SDL_SENSOR_ACCEL_R,
                SDL_SENSOR_GYRO_R
        };
        unsigned int i;

        controller_id = SDL_JoystickGetDeviceInstanceID(device_index);
        if (controller_id < 0) {
            SDL_Log("Couldn't get controller ID: %s\n", SDL_GetError());
            return;
        }

        if (FindController(controller_id) >= 0) {
            /* We already have this controller */
            return;
        }

        controller = SDL_GameControllerOpen(device_index);
        if (controller == NULL) {
            SDL_Log("Couldn't open controller: %s\n", SDL_GetError());
            return;
        }

        controllers = (SDL_GameController **)SDL_realloc(gamecontrollers, (num_controllers + 1) * sizeof(*controllers));
        if (controllers == NULL) {
            SDL_GameControllerClose(controller);
            return;
        }

        controllers[num_controllers++] = controller;
        gamecontrollers = controllers;
        gamecontroller = controller;
        trigger_effect = 0;

        if (verbose) {
        const char *name = SDL_GameControllerName(gamecontroller);
        const char *path = SDL_GameControllerPath(gamecontroller);
            SDL_Log("Opened game controller %s%s%s\n", name, path ? ", " : "", path ? path : "");
        }

        firmware_version = SDL_GameControllerGetFirmwareVersion(gamecontroller);
        if (firmware_version) {
            if (verbose) {
                SDL_Log("Firmware version: 0x%x (%d)\n", firmware_version, firmware_version);
            }
        }

        for (i = 0; i < SDL_arraysize(sensors); ++i) {
            SDL_SensorType sensor = sensors[i];

            if (gameController.hasSensor(sensor)) {

            }
            if (SDL_GameControllerHasSensor(gamecontroller, sensor)) {
                if (verbose) {
                    SDL_Log("Enabling %s at %.2f Hz\n", GetSensorName(sensor), SDL_GameControllerGetSensorDataRate(gamecontroller, sensor));
                }
                SDL_GameControllerSetSensorEnabled(gamecontroller, sensor, SDL_TRUE);
            }
        }

        if (SDL_GameControllerHasRumble(gamecontroller)) {
            SDL_Log("Rumble supported");
        }

        if (SDL_GameControllerHasRumbleTriggers(gamecontroller)) {
            SDL_Log("Trigger rumble supported");
        }

        UpdateWindowTitle();
    }

    static void SetController(SDL_JoystickID controller)
    {
        int i = FindController(controller);

        if (i < 0) {
            return;
        }

        if (gamecontroller != gamecontrollers[i]) {
            gamecontroller = gamecontrollers[i];
            UpdateWindowTitle();
        }
    }

    static void DelController(SDL_JoystickID controller)
    {
        int i = FindController(controller);

        if (i < 0) {
            return;
        }

        SDL_GameControllerClose(gamecontrollers[i]);

        --num_controllers;
        if (i < num_controllers) {
            SDL_memcpy(&gamecontrollers[i], &gamecontrollers[i + 1], (num_controllers - i) * sizeof(*gamecontrollers));
        }

        if (num_controllers > 0) {
            gamecontroller = gamecontrollers[0];
        } else {
            gamecontroller = NULL;
        }
        UpdateWindowTitle();
    }


//    static void CyclePS5TriggerEffect()
//    {
//        DS5EffectsState_t state;
//
//        Uint8 effects[3][11] = {
//        /* Clear trigger effect */
//        { 0x05, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        /* Constant resistance across entire trigger pull */
//        { 0x01, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0 },
//        /* Resistance and vibration when trigger is pulled */
//        { 0x06, 15, 63, 128, 0, 0, 0, 0, 0, 0, 0 },
//    };
//
//        trigger_effect = (trigger_effect + 1) % SDL_arraysize(effects);
//
//        SDL_zero(state);
//        state.ucEnableBits1 |= (0x04 | 0x08); /* Modify right and left trigger effect respectively */
//        SDL_memcpy(state.rgucRightTriggerEffect, effects[trigger_effect], sizeof(effects[trigger_effect]));
//        SDL_memcpy(state.rgucLeftTriggerEffect, effects[trigger_effect], sizeof(effects[trigger_effect]));
//        SDL_GameControllerSendEffect(gamecontroller, &state, sizeof(state));
//    }

    // @Test
    public void cyclePS5TriggerEffect() {
        try (var arena = Arena.ofConfined()) {
            MemorySegment state = DS5EffectsState_t.allocate(arena);

            // SDL_GameController gameController = SDL_GameController;''

            SDL_GameControllerSendEffect(gameController, state, state.byteSize());
        }
    }
}
