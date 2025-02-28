// File: Slider.java
package sketchui;

// import processing.core.PApplet;

// public class Slider {
//     PApplet p;
//     float x, y, w, value;
//     float min, max;

//     public Slider(PApplet p, float x, float y, float w, float min, float max) {
//         this.p = p;
//         this.x = x;
//         this.y = y;
//         this.w = w;
//         this.min = min;
//         this.max = max;
//         this.value = min;
//     }

//     public void display() {
//         p.fill(200);
//         p.rect(x, y, w, 10);  // Slider track
//         p.fill(0);
//         p.ellipse(x + map(value, min, max, 0, w), y + 5, 20, 20);  // Slider thumb
//     }

//     public void update(float mx) {
//         value = PApplet.constrain(map(mx, x, x + w, min, max), min, max);
//     }
// }
