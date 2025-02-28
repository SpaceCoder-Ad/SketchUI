package sketchui;

import processing.core.PApplet;
import processing.core.PFont;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;

public class Button {
//  @Button.Invisible public PApplet papplet;
  public static PApplet parent;

  private int fillColor, strokeColor, bgColor, fgColor, hoverColor, activeColor, textColor, cursorColor;
  private int borderColor;
  private float posX, posY, w, h, tl, tr, br, bl, roundness;
  private String label, value;
  private boolean isClicked, isPressed, isHovered;
  private PFont font;

  private Runnable action;

  public Button(PApplet p){
    parent = p;
    defaultSettings();
  }
  
  public Button(PApplet p, String label){
    parent = p;
    this.label = label;
    defaultSettings();
  }

  public Button(PApplet p, String label, float x, float y){
    parent = p;
    defaultSettings();
    this.label = label;
    this.posX = x;
    this.posY = y;
  }

  public Button(PApplet p, String label, float x, float y, float w, float h){
    parent = p;
    defaultSettings();
    this.label = label;
    this.posX = x;
    this.posY = y;
    this.w = w;
    this.h = h;
  }

  public Button(PApplet p, String label, int alignment, float x, float y){
    parent = p;
    this.label = label;
    defaultSettings();
    switch (alignment) {
      case PApplet.CENTER:
        this.posX = x - w / 2f;
        this.posY = y - h / 2f;
        break;
      case PApplet.CORNER:
        this.posX = x;
        this.posY = y;
        break;
      default:
        throw new IllegalArgumentException("Invalid alignment type");
    }
  }
  public Button(PApplet p, String label, int alignment, float x, float y, float w, float h){
    parent = p;
    this.label = label;
    defaultSettings();
    this.w = w;
    this.h = h;
    switch (alignment) {
      case PApplet.CENTER:
        this.posX = x - w / 2f;
        this.posY = y - h / 2f;
        break;
      case PApplet.CORNER:
        this.posX = x;
        this.posY = y;
        break;
      default:
        throw new IllegalArgumentException("Invalid alignment type");
    }
  }
  public Button(PApplet p, String label, int bgColor, int alignment, float x, float y, float w, float h){
    this.parent = p;
    this.label = label;
    defaultSettings();
    this.w = w;
    this.h = h;
    this.bgColor = bgColor;
    this.hoverColor = parent.color(bgColor, 210);
    this.fgColor = parent.color(bgColor, 180);
    this.activeColor = parent.color(bgColor);

    switch (alignment) {
      case PApplet.CENTER:
        this.posX = x - w / 2f;
        this.posY = y - h / 2f;
        break;
      case PApplet.CORNER:
        this.posX = x;
        this.posY = y;
        break;
      default:
        throw new IllegalArgumentException("Invalid alignment type");
    }
  }

  private int createColor(int r, int g, int b) {
    return parent.color(r, g, b);
  }

//  public Button(PApplet p, String label, int bgColor, float x, float y, float w, float h){
//    this.parent = p;
//    this.label = label;
//    defaultSettings();
//    this.w = w;
//    this.h = h;
//    this.bgColor = bgColor;
//    this.fgColor = parent.color(bgColor, 100);
//    this.activeColor = parent.color(bgColor, 50);
//  }

  private void defaultSettings() {
    font = parent.createFont("Monospaced.plain", 15);
    posX = 10;
    posY = 30;
    w = 100;
    h = 30;
    roundness = 3;

    value = label;

    fillColor = parent.color(200);
    strokeColor = parent.color(0);
    bgColor = parent.color(249, 249, 249);
    hoverColor = parent.color(206, 206, 206);
    fgColor = parent.color(206, 206, 206, 200);
    activeColor = parent.color(103, 103, 103);
    textColor = parent.color(0);
    borderColor = parent.color(0);

    isClicked = false;
    buttonAction(this::nothing);
  }

  public Button setSize(float w, float h) {
    this.w = w;
    this.h = h;
    return this;
  }

  public Button setSize(float w, float h, float r) {
    this.w = w;
    this.h = h;
    this.roundness = r;
    return this;
  }

  public Button setSize(float w, float h, float tl, float tr, float br, float bl) {
    this.w = w;
    this.h = h;
    this.tl = tl;
    this.tr = tr;
    this.br = br;
    this.bl = bl;
    return this;
  }

  public Button setPosition(int alignment, float x, float y) {
    switch (alignment) {
      case PApplet.CENTER:
        this.posX = x - w / 2f;
        this.posY = y - h / 2f;
        break;
      case PApplet.CORNER:
        this.posX = x;
        this.posY = y;
        break;
      default:
        throw new IllegalArgumentException("Invalid alignment type");
    }
    return this;
  }

  public Button setPosition(float x, float y) {
    this.posX = x;
    this.posY = y;
    return this;
  }

  public Button setLabel(String label) {
    this.label = label;
    return this;
  }

  public Button setLabel(String label, int textColor) {
      this.label = label;
      this.textColor = textColor;
      return this;
  }
  public Button setLabelColor(int textColor) {
      this.textColor = textColor;
      return this;
  }
  public Button setLabelColor(int r, int g, int b) {
      this.textColor = parent.color(r, g, b);;
      return this;
  }
  public Button setFill(int r, int g, int b) {
    fillColor = parent.color(r, g, b);
    return this;
  }

  public Button setFill(int gray) {
    fillColor = gray;
    return this;
  }

  public Button setFont(PFont font) {
    if (font == null) {
      throw new IllegalArgumentException("Font cannot be null");
    }
    this.font = font;
    return this;
  }

  public Button setBackground(int gray) {
    bgColor = gray;
    return this;
  }
  public Button setBackground(int hue,int gray) {
    bgColor = parent.color(hue, gray);
    return this;
  }
  public Button setBackground(int r, int g, int b) {
    bgColor = createColor(r, g, b);
    return this;
  }
  public Button setForeground(int gray) {
    fgColor = gray;
    return this;
  }
  public Button setForeground(int r, int g, int b) {
    fgColor = createColor(r, g, b);
    return this;
  }
  public Button setBorderColor(int grey) {
    borderColor = grey;
    return this;
  }
  public Button setBorderColor(int r, int g, int b) {
    borderColor = createColor(r, g, b);
    return this;
  }
  public Button setColorActive(int gray) {
    activeColor = gray;
    return this;
  }
  public Button setColorActive(int r, int g, int b) {
    activeColor = createColor(r, g, b);
    return this;
  }
  public Button setFocus(boolean active) {
    isClicked = active;
    return this;
  }

  public Button setValue(String value) {
    this.value = value;
    return this;
  }

  public String getValue() {
    return value;
  }

  public float getPosX() {
    return posX;
  }

  public float getPosY() {
    return posY;
  }
  public float getWidth() {
    return w;
  }
  public float getHeight() {
    return h;
  }

  public float[] getPos() {
      return new float[]{getPosX(), getPosY()};
  }

  public void display() {
//    clickable();
    parent.strokeWeight(1.5f);
    parent.stroke(isMouseOver() || isClicked() ? activeColor : borderColor);

//    if (isClicked && parent.frameCount % 20 <= 0) {
//      isClicked = false;
//    }
//    if (isClicked()) {
//      PApplet.println(getValue());
//    }

    parent.fill(isMouseOver() ?  (isClicked()? fgColor : hoverColor): bgColor);

    if (roundness >= 0) {
      parent.rect(posX, posY, w, h, roundness);
    } else {
      parent.rect(posX, posY, w, h);
    }
    parent.fill(textColor);
    parent.textFont(font);
    parent.textAlign(PApplet.CENTER, PApplet.CENTER);
    parent.text(label, posX + w / 2, posY + h / 2);

//    isClicked = parent.mouseX > posX && parent.mouseX < posX + w && parent.mouseY > posY && parent.mouseY < posY + h;
  }
  public void buttonAction(Runnable action) {
    this.action = action;
  }

  public Button whichButton(Button... btn) {
    for (Button b : btn) {
      if (isClicked()) {
        return b;
      }
    }
      return null;
  }

  public void clickable() {
    isClicked = parent.mouseX > posX && parent.mouseX < posX + w && parent.mouseY > posY && parent.mouseY < posY + h;
  }

  public boolean isMouseOver() {
    return parent.mouseX > posX && parent.mouseX < posX + w && parent.mouseY > posY && parent.mouseY < posY + h;
  }

  public boolean isClicked() {
    return isMouseOver() && parent.mousePressed;
  }

  public boolean isMousePressedOver() {
    return isMouseOver() && parent.mousePressed;
  }
  public void runAction() {
    action.run();
  }
  public void nothing() {}


//  @Retention( RetentionPolicy.RUNTIME ) @interface Invisible {
//  }
}
