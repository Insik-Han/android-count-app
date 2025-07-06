# Android Count App

A simple Android counter application built with Jetpack Compose that demonstrates basic state management and UI interactions.

## Features

- **Increment Counter**: Tap the "+" button to increase the count
- **Decrement Counter**: Tap the "-" button to decrease the count (minimum value is 0)
- **Reset Counter**: Tap the "Reset" button to set the counter back to 0
- **Material 3 Design**: Modern UI following Material Design 3 guidelines
- **Edge-to-Edge Display**: Supports full-screen content with proper system bar handling

## Screenshots

The app displays a centered counter with increment/decrement buttons and a reset option.

## Technical Details

### Built With
- **Kotlin**: Primary programming language
- **Jetpack Compose**: Modern Android UI toolkit
- **Material 3**: Latest Material Design components
- **Android SDK**: Target SDK 36, Minimum SDK 24

### Architecture
- Single Activity architecture with Compose
- State management using a dedicated `CounterState` class
- Separation of business logic from UI components
- Composable functions for UI components

### Key Components
- `MainActivity`: Main entry point with edge-to-edge support
- `CountButtonScreen`: Main composable for UI layout and interactions
- `CounterState`: State holder class managing counter logic
  - Encapsulates increment, decrement, reset operations
  - Prevents negative counter values
  - Read-only state exposure for better encapsulation
- Material 3 theming with dynamic colors

## Requirements

- Android Studio Hedgehog or newer
- Kotlin 1.9+
- Android Gradle Plugin 8.0+
- Minimum Android API 24 (Android 7.0)

## Installation

1. Clone the repository:
   ```bash
   git clone git@github.com:Insik-Han/android-count-app.git
   ```

2. Open the project in Android Studio

3. Sync the project with Gradle files

4. Run the app on an emulator or physical device

## Project Structure

```
android-count-app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/count/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── CounterState.kt
│   │   │   │   └── ui/theme/
│   │   │   │       ├── Color.kt
│   │   │   │       ├── Theme.kt
│   │   │   │       └── Type.kt
│   │   │   └── res/
│   │   ├── test/
│   │   │   └── java/com/example/count/
│   │   │       └── CounterStateTest.kt
│   │   └── androidTest/
│   │       └── java/com/example/count/
│   │           └── CountAppInstrumentedTest.kt
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Development

The app uses Jetpack Compose for the UI layer with a clean separation of concerns:

- Business logic is encapsulated in the `CounterState` class
- UI state is managed using `remember { CounterState() }` in composables
- The `CounterState` class handles all counter operations and validation
- UI components are arranged using `Column` and `Row` composables
- Material 3 components provide consistent styling

### Testing

The project includes comprehensive test coverage:

- **Unit Tests** (`CounterStateTest`): Test the business logic of counter operations
- **Instrumented Tests** (`CountAppInstrumentedTest`): Test UI interactions and state changes

## Contributing

Feel free to submit issues and enhancement requests!

## License

This project is open source and available under the MIT License.