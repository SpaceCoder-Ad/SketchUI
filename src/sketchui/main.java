// File: SketchUI.java
package sketchui;

import processing.core.PApplet;

import java.util.ArrayList;

public class main {
  static ArrayList<Button> buttons = new ArrayList<>();

  public static Button createButton(PApplet parent) {
    Button button = new Button(parent);
    buttons.add(button);
    return button;
  }
  public static Button createButton(PApplet parent, String label) {
    Button button = new Button(parent, label);
    buttons.add(button);
    return button;
  }
  public static Button createButton(PApplet parent, String label, float x, float y) {
    Button button = new Button(parent, label, x, y);
    buttons.add(button);
    return button;
  }
  public static Button createButton(PApplet parent, String label, float x, float y, float w, float h) {
    Button button = new Button(parent, label, x, y, w, h);
    buttons.add(button);
    return button;
  }

  public static Button createButton(PApplet parent, String label, int alignment, float x, float y) {
    Button button = new Button(parent, label, alignment, x, y);
    buttons.add(button);
    return button;
  }
  public static Button createButton(PApplet parent, String label, int bgColor, int alignment, float x, float y, float w, float h) {
    Button button = new Button(parent, label, bgColor, alignment, x, y, w, h);
    buttons.add(button);
    return button;
  }
//  public static Button createButton(PApplet parent, String label, float x, float y, float w, float h, int bgColor, int alignment) {
//    Button button = new Button(parent, label, bgColor, alignment, x, y, w, h);
//    buttons.add(button);
//    return button;
//  }

  public static Button whichButton(Button... btn) {
    for (Button b : btn) {
      if (b.isClicked()) {
        return b;
      }
    }
    return null;
  }
  public static TextField createTextField(PApplet parent) {
    TextField textField = new TextField(parent);
    return textField;
  }
  public static TextField createTextField(PApplet parent, String label) {
    TextField textField = new TextField(parent, label);
    return textField;
  }
  public static TextField createTextField(PApplet parent, String label, float x, float y) {
    TextField textField = new TextField(parent, label, x, y);
    return textField;
  }
  public static TextField createTextField(PApplet parent, String label, float x, float y, float w, float h) {
    TextField textField = new TextField(parent, label, x, y, w, h);
    return textField;
  }
  public static TextField createTextField(PApplet parent, String label, float x, float y, float w, float h, float r) {
    TextField textField = new TextField(parent, label, x, y, w, h, r);
    return textField;
  }
  public static TextField createTextField(PApplet parent, float x, float y) {
    TextField textField = new TextField(parent, x, y);
    return textField;
  }
  public static TextField createTextField(PApplet parent, float x, float y, float w, float h) {
    TextField textField = new TextField(parent, x, y, w, h);
    return textField;
  }
  public static TextField createTextField(PApplet parent, float x, float y, float w, float h, float r) {
    TextField textField = new TextField(parent, x, y, h, r);
    return textField;
  }
//  public static TextField createTextField(PApplet parent, String label, float x, float y, float w, float h, float r) {
//    return new TextField(parent, label, x, y, w, h, r);
//  }

  public static Button buttonListener() {
    PApplet parent = null;
    for(Button b : buttons) {
      if (b.isClicked()) {
        return b;
      }
      parent = b.parent;
    }
    return (new Button(parent).setValue(""));
  }
}