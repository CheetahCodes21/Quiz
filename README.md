# Online Quiz
Online Test Application in Java with Swing GUI
The code represents a  online test application with a graphical user interface (GUI) developed using Java's Swing library. The application offers a comprehensive set of features to deliver an interactive testing experience.

Upon execution, the application launches a window that serves as the main interface. This window is implemented as an extension of the JFrame class. It includes various GUI components to facilitate the testing process.

The user interface consists of a JLabel component that displays the current question to the user, and a set of JRadioButton components that present the available answer options. The GUI layout is carefully designed to ensure an intuitive and user-friendly experience.

The application supports ten distinct questions, each accompanied by a set of answer choices. The user progresses through the questions by clicking the "Next" button, which triggers an action event listener. This listener validates the selected answer and updates the user's progress accordingly.

To enhance usability, the application includes a "Bookmark" feature that allows users to mark specific questions for future reference. The feature works by dynamically generating bookmark buttons, each associated with a particular question. Clicking a bookmarked question button retrieves the corresponding question and answer choices, enabling users to conveniently revisit and modify their answers.

Upon reaching the final question, the "Next" button transforms into a "Result" button. Clicking this button triggers the computation of the user's final score. The score calculation takes into account the correctness of the selected answers throughout the test. The result is displayed using a message dialog, providing immediate feedback to the user.

The code employs well-structured methods such as set() to dynamically set the question text and answer options based on the current question. Additionally, the check() method efficiently verifies the correctness of the selected answer for each question, ensuring accurate scoring.

Overall, this code showcases a robust and intricately designed online test application, offering features such as multiple-choice questions, bookmarking, and scoring capabilities. It demonstrates the extensive potential of Java's Swing library for creating sophisticated GUI applications.
