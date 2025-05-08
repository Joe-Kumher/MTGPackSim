# MTG Pack Opening Simulator

## Overview

This is a personal side project aimed at creating a realistic Magic: The Gathering pack opening simulator. The application intends to serve as a "heat-check" for potential real-life pack openings, a pull tracker, and a cost-benefit analysis tool for virtual pack openings.

The application will:

* Simulate opening MTG booster packs with accurate pull probabilities for every released set.
* Display the opened cards to the user.
* Track the value of pulled cards using data from TCGPlayer (or a similar API).
* Allow users to log their virtual pack openings and track costs.
* Provide a cost-benefit analysis based on pack costs and card values.

The frontend UI will be a simplified web application inspired by the PokemonTCG Live app's pack opening screen, featuring a stylized pack that users can "open" to reveal the cards.

## Tech Stack

* **Backend:** Java
* **Database:** PostgreSQL
* **API Integration:**
    * Scryfall API (for card data and set information)
    * TCGPlayer API (or alternative for card values)
* **Frontend:** HTML, CSS, JavaScript

## Current Status

This project is in the initial development phase. The current focus is on building the **Minimum Viable Product (MVP)**:

* **MVP Goal:** To accurately simulate the opening of a single, chosen MTG set, displaying the pulled cards with their names.

**Key MVP Functionality:**

* Ability for the user to select one specific MTG set.
* Simulation of opening a virtual pack from the selected set based on researched rarity distributions.
* Display of the names (and ideally images) of the pulled cards on a basic webpage.
* A simple backend API endpoint in Java to handle the pack opening simulation and card data retrieval from Scryfall.

## Planned Features (Beyond MVP)

* Support for opening packs from all released MTG sets.
* Integration with the TCGPlayer API (or alternative) to display real-time card values.
* User account creation and management.
* Logging and tracking of virtual pack openings and pulled cards.
* Tracking the cost of virtual packs.
* Calculation and display of cost-benefit analysis for opened packs.
* A more visually appealing frontend UI with a stylized pack opening animation.

## Diagrams (Planned)

The following diagrams will be used throughout the development process:

* **Use Case Diagrams (UML):** To illustrate user interactions with the application.
* **Entity-Relationship Diagram (ERD):** To model the database schema.
* **Class Diagrams (UML):** To detail the Java backend structure.
* **Workflow Diagrams:** To visualize specific processes like pack opening.
* **Component Diagrams (UML):** To show the high-level components of the system.

## Getting Started (For Developers)

1.  **Prerequisites:**
    * Java Development Kit (JDK) installed.
    * PostgreSQL installed and running.
    * Maven or Gradle (for building the Java backend).
    * A code editor or IDE (e.g., IntelliJ IDEA, VS Code).
    * Basic understanding of Git.

2.  **Setup:**
    * Clone the repository (once it's created).
    * Set up your PostgreSQL database.
    * Configure database connection details in the backend application.
    * (For MVP) No external API keys are strictly required yet, but you might want to explore the Scryfall API.

3.  **Running the Application (MVP):**
    * Build the Java backend using Maven or Gradle.
    * Run the backend application.
    * Open the `index.html` (or similar) file in your web browser (once the basic frontend is created).

## Contributing

This is currently a personal side project, and contributions are not actively being sought at this time. However, if you have suggestions or feedback, feel free to reach out!

## License

[Choose a license for your project, e.g., MIT License]

## Contact

[Your Name/Contact Information - Optional]