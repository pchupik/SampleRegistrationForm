# Sample Registration Form
A simple registration form which contains user name and email input fields with simple navigation to the empty application home screen after successful registration.

Project requirements:
- uses **Clean Architecture**
- Android **Hilt** used for the Dependency Injection
- implement standard repository pattern with simulation of successful user sign up flow
- Presentation layer 
  - contains a simple form with username and email input fields using **ViewBinding**(not DataBinding)
  - uses MVVM pattern with Jetpack ViewModel
- Domain layer contains pure UseCases with UnitTest code coverage
- all asynchronous work performed using Kotlin **Coroutines**.
- use JetPack Navigation Component for app navigation.
- UI - as simple as possible.
