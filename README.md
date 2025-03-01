# SketchUI Library

A simple UI library for Processing with **Button** and **TextField** components.

## Usage

### Button

- Create a button with `createButton()`.
- Call `display()` to draw it.
- Call `runAction()` to check if it was clicked.


### TextField

- Create a text field with `createTextField()`.
- Call `display()` to draw it.
- Call `setValue()` to change the text.

## Installation

Follow these steps to install and use the **SketchUI** library in your Processing project:

### 1. **Download the Library:**
   - Download the latest version of the **SketchUI** library from the repository. You can either clone the repository or download it as a ZIP file.
   
   If you are using the **JAR** file from the repository, the library is located at:
   ```
   out/artifacts/SketchUI_jar/SketchUI.jar
   ```

### 2. **Install the Library in Processing:**

   - **For Windows and macOS:**
     1. Download the `.jar` file (`SketchUI.jar`) from the repository or compile it from the source.
     2. Open **Processing**.
     3. Go to the **Sketch** menu and select **Import Library...** > **Add Library...**.
     4. Click on **Add JAR** and select the `SketchUI.jar` file you downloaded or compiled.

   - **For Linux:**
     1. Download the `.jar` file (`SketchUI.jar`) or compile it from the repository.
     2. Open **Processing**.
     3. Navigate to the **Sketch** menu and select **Import Library...** > **Add Library...**.
     4. Click on **Add JAR** and navigate to the location where you saved `SketchUI.jar`. Select it to add to your project.

   - **Alternative method for all platforms:**
     1. If you prefer to manually include the library:
        - Navigate to the **Processing libraries** folder:
          - **On Windows**: `Documents/Processing/libraries/`
          - **On macOS**: `Documents/Processing/libraries/`
          - **On Linux**: `~/Processing/libraries/`
     2. Create a folder named `SketchUI`.
     3. Inside the `SketchUI` folder, create another folder named `library`.
     4. Place the `SketchUI.jar` file inside the `library` folder. Your directory structure should look like this:
     ```
     ~/Processing/libraries/SketchUI/library/SketchUI.jar
     ```

### 3. **Include the Library in Your Sketch:**
   - After installing the library, you need to import it at the beginning of your Processing sketch:
     ```java
     import sketchui.*;
     import static sketchui.main.*; // If you don't import the static methods, you would have to explicitly reference the main class each time you call a static method. 
     ```

### 4. **Start Using SketchUI:**
   - Now that the library is installed and imported, you can start using the UI components like **Button** and **TextField** in your sketch.

## Basic Example Usage

Here’s a basic example of using **Button** and **TextField** components:

```java
import sketchui.*;
import static sketchui.main.*;

Button home, primary, warning, danger;
int x = 200, y = 50, w = 150, h = 40;
String message = "";

void setup () {
  size(800, 600);

  // Create buttons with different labels and styles
  home = createButton(this, "Home", color(200), CENTER, x, y, w, h);
  primary = createButton(this, "Primary", color(0, 0, 255), CENTER, x + 180, y, w, h);
  warning = createButton(this, "Warning", color(255, 217, 0), CENTER, x + 180*2, y, w, h);
  danger = createButton(this, "Danger", color(240, 7, 27), CENTER, x + 180*3, y, w, h);

  // Set values and labels for each button
  home.setValue("Redirecting to Home page...");
  primary.setValue("Primary button is active").setLabelColor(255);
  warning.setValue("Warning: Proceed with caution").setLabelColor(255);
  danger.setValue("Danger! Red button pressed").setSize(w, h, 0).setLabelColor(255);
}

void draw() {
  background(0);
  
  // Display all the buttons
  home.display();
  primary.display();
  warning.display();
  danger.display();

  // Display the selected button message in the center
  fill(255);
  textSize(20);
  textAlign(CENTER);
  text(message, width / 2, height / 2);
}

void mousePressed() {
  // Get the value of the clicked button
  message = buttonListener().getValue();
}
```

### Button Class Methods

The **Button** class includes the following methods:

```java
class Button {
  // Constructors
  Button(PApplet p)
  Button(PApplet p, String label)
  Button(PApplet p, String label, float x, float y)
  Button(PApplet p, String label, float x, float y, float w, float h)
  Button(PApplet p, String label, int alignment, float x, float y)
  Button(PApplet p, String label, int alignment, float x, float y, float w, float h)
  Button(PApplet p, String label, int bgColor, int alignment, float x, float y, float w, float h)

  // Setters
  Button setSize(float w, float h)
  Button setSize(float w, float h, float r)
  Button setSize(float w, float h, float tl, float tr, float br, float bl)
  Button setPosition(int alignment, float x, float y)
  Button setPosition(float x, float y)
  Button setLabel(String label)
  Button setFill(int r, int g, int b)
  Button setFill(int gray)
  Button setFont(PFont font)
  Button setBackground(int gray)
  Button setBackground(int hue, int gray)
  Button setBackground(int r, int g, int b)
  Button setForeground(int gray)
  Button setForeground(int r, int g, int b)
  Button setBorderColor(int grey)
  Button setBorderColor(int r, int g, int b)
  Button setColorActive(int gray)
  Button setColorActive(int r, int g, int b)
  Button setFocus(boolean active)
  Button setValue(String value)
  String getValue()
  float getPosX()
  float getPosY()
  float getWidth()
  float getHeight()
  float[] getPos()
  void display()
  void buttonAction(Runnable action)
  Button whichButton(Button... btn)
  void clickable()
  boolean isMouseOver()
  boolean isClicked()
  void runAction()
}
```

### TextField Class Methods

The **TextField** class includes the following methods:

```java
class TextField {
  // Constructors
  public TextField(PApplet p)
  public TextField(PApplet p, String label)
  public TextField(String label, String placeholder)
  public TextField(PApplet p, String label, float x, float y)
  public TextField(PApplet p, String label, float x, float y, float w, float h)
  public TextField(PApplet p, String label, float x, float y, float w, float h, float r)
  public TextField(PApplet p, float x, float y)
  public TextField(PApplet p, float x, float y, float w, float h)
  public TextField(PApplet p, float x, float y, float w, float h, float r)

  // Setters
  public TextField setPosition(float x, float y)
  public TextField setFill(int r, int g, int b)
  public TextField setFill(int gray)
  public TextField setFont(PFont font)
  public TextField setBackground(int gray)
  public TextField setBackground(int hue, int gray)
  public TextField setBackground(int r, int g, int b)
  public TextField setForeground(int gray)
  public TextField setForeground(int r, int g, int b)
  public TextField setBorderColor(int grey)
  public TextField setBorderColor(int r, int g, int b)
  public TextField setColorActive(int gray)
  public TextField setColorActive(int r, int g, int b)
  public TextField setFocus(boolean active)
  public TextField setValue(String value)
  public void setPlaceholder(String placeholder)
  public String getValue()
  public float getPosX()
  public float getPosY()
  public float getWidth()
  public float getHeight()
  public float[] getPos()
  public void defaultSettings()
  public void textFieldAction(Runnable action)
  public void display()
  public void checkActive()
  public void keyEvent()
  public boolean isMouseOver()
  public boolean isClicked()
  public boolean isSymbol(char c)
  public void runAction()
}
```

### Main Class Methods

The **main** class contains the following methods:

```java
public class main {
  public static Button createButton(PApplet parent)
  public static Button createButton(PApplet parent, String label)
  public static Button createButton(PApplet parent, String label, float x, float y)
  public static Button createButton(PApplet parent, String label, float x, float y, float w, float h)
  public static Button createButton(PApplet parent, String label, int alignment, float x, float y)
  public static Button createButton(PApplet parent, String label, int bgColor, int alignment, float x, float y, float w, float h)
  public static Button whichButton(Button... btn)
  public static TextField createTextField(PApplet parent)
  public static TextField createTextField(PApplet parent, String label)
  public static TextField createTextField(PApplet parent, String label, float x, float y)
  public static TextField createTextField(PApplet parent, String label, float x, float y, float w, float h)
  public static TextField createTextField(PApplet parent, String label, float x, float y, float w, float h, float r)
  public static TextField createTextField(PApplet parent, float x, float y)
  public static TextField createTextField(PApplet parent, float x, float y, float w, float h)
  public static TextField createTextField(PApplet parent, float x, float y, float w, float h, float r)
  public static Button buttonListener()
}
```


