# Community Center Management App

## Overview
This Android application is designed to efficiently manage the activities, users, and resources of a community center. It includes features for user registration, activity management, library access, and worker coordination. Built with Java and SQLite, the app ensures a seamless experience for both administrators and users.

---

## Features

### User Management
- **RegisterActivity**: Allows users to sign up.
- **LoginActivity**: Handles user authentication.
- **UpdateUsers**: Enables editing user information.
- **AllUsers**: Displays a list of all registered users.

### Class and Activity Management
- **ClassesActivity**: Displays available classes.
- **ClassesAdapter**: Adapter for class data in list views.
- **UpdateClasses**: Enables editing class information.
- **AllClassesManager**: Administrative view for managing all classes.
- **ScrollChooseActivity**: Allows users to scroll and choose activities.
- **ScrollChooseManageActivity**: Administrative interface for managing activities.
- **ClassesOpenHelper**: SQLite helper for managing class data.

### Specialized Activities
- **GymActivity**: Focused on gym-related activities.
- **LibraryActivity**: Provides access to library resources.

### Worker Management
- **WorkersActivity**: Handles tasks related to worker coordination.

### General Components
- **MainActivity**: Entry point of the application.
- **Instructor**: Represents instructor details.
- **SqliteHelper**: General SQLite database helper.

---

## Project Structure
The project is organized into several classes and activities to ensure modularity and scalability. Below is a summary of the key files and their purposes:

- **AllClassesManager**: Handles all class-related management tasks.
- **AllUsers**: Displays a list of all users.
- **Classes**: Data model for classes.
- **ClassesAdapter**: Adapter for displaying classes in views.
- **ClassesOpenHelper**: SQLite database helper for classes.
- **Instructor**: Data model for instructors.
- **LibraryActivity**: Interface for library-related functions.
- **LoginActivity**: Manages user login.
- **MainActivity**: Main entry point for the app.
- **RegisterActivity**: Manages user registration.
- **ScrollChooseActivity**: User interface for selecting activities.
- **ScrollChooseManageActivity**: Admin interface for managing activity selection.
- **SqliteHelper**: Database helper for general SQLite operations.
- **UpdateClasses**: Allows updating class details.
- **UpdateUsers**: Allows updating user details.
- **User**: Data model for users.
- **UserAdapter**: Adapter for displaying user data.
- **WorkersActivity**: Interface for worker coordination.

---

## Technologies Used
- **Programming Language**: Java
- **Database**: SQLite
- **Development Environment**: Android Studio

---

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```

2. Open the project in Android Studio.

3. Sync the Gradle files.

4. Configure the database (if necessary) using **SqliteHelper** and the respective helper classes for users and classes.

5. Build and run the application on an emulator or a physical device.

---

## Future Improvements
- Add cloud database support for better scalability.
- Implement push notifications for activity reminders.
- Add multi-language support to cater to diverse users.
- Enhance UI/UX for a more intuitive user experience.

---

## License
This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
