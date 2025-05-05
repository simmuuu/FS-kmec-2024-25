# CSS - MCQ  

### Question 1  
What happens when a user hovers over a navigation link (`<a>` tag) in the navbar?  

```css
.nav-links a {
    transition: 0.3s;
}

.nav-links a:hover {
    background-color: #575757;
    border-radius: 5px;
}
```

- a. The navbar disappears from the page.  
- b. The link changes background color smoothly over `0.3s`.  
- c. The text color changes instantly.  
- d. The hover effect applies only when the user clicks the link.  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** b. The link changes background color smoothly over `0.3s`.  

  **Explanation:**  
  The `transition: 0.3s;` property ensures that any change in CSS properties (like `background-color` and `border-radius`) will occur smoothly over `0.3s`. When the user hovers over the `<a>` element, the background color gradually changes to `#575757`, and the corners round slightly.  
</details>  

---

### Question 2  
What does the following CSS animation do in the `.transition-box` div?  

```css
@keyframes colorChange {
    0% { background-color: blue; }
    33% { background-color: green; }
    66% { background-color: red; }
    100% { background-color: blue; }
}

.transition-box {
    animation: colorChange 3s infinite;
}
```

- a. The box remains blue all the time.  
- b. The box changes from blue → green → red → blue continuously every 3 seconds.  
- c. The box grows in size on hover.  
- d. The box color changes only once and stops.  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** b. The box changes from blue → green → red → blue continuously every 3 seconds.  

  **Explanation:**  
  The `@keyframes colorChange` defines a sequence of color changes. The `animation: colorChange 3s infinite;` property ensures that the animation runs continuously, with the background cycling through blue → green → red → blue every 3 seconds.  
</details>  

---

### Question 3  
What will happen when a user hovers over the `.transition-box` with the following CSS applied?  

```css
.transition-box {
    width: 100px;
    height: 100px;
    background-color: blue;
    margin: 50px auto;
    transition: transform 0.5s ease-in-out;
}

.transition-box:hover {
    transform: rotate(45deg) scale(1.2);
}
```

- a. The box will disappear from the screen.  
- b. The box will change color from blue to red.  
- c. The box will rotate 45 degrees and increase in size smoothly over 0.5 seconds.  
- d. The box will immediately rotate and scale up without any smooth effect.  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** c. The box will rotate 45 degrees and increase in size smoothly over 0.5 seconds.  

  **Explanation:**  
  The `transition: transform 0.5s ease-in-out;` property ensures that any `transform` changes happen smoothly over `0.5s`. When the user hovers over the box, the `transform: rotate(45deg) scale(1.2);` rule takes effect, causing the box to rotate by 45 degrees and grow to 1.2 times its original size in a smooth motion.  
</details>  

---

### Question 4  
Which line of CSS ensures a smooth transition effect when the background color changes?  

```css
.transition-box {
    width: 100px;
    height: 100px;
    background-color: blue;
    margin: 50px auto;
    transition: background-color 0.5s ease, transform 0.5s ease;
}
```

- a. `background-color: blue;`  
- b. `margin: 50px auto;`  
- c. `transition: background-color 0.5s ease, transform 0.5s ease;`  
- d. `animation: colorChange 3s infinite;`  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** c. `transition: background-color 0.5s ease, transform 0.5s ease;`  

  **Explanation:**  
  The `transition` property ensures that specified CSS changes (in this case, `background-color` and `transform`) happen gradually over `0.5s` instead of instantly. This allows for a smooth visual effect when the background color or transformation changes.  
</details>  

---

### Question 5  
What will happen if we change the animation property in the `.transition-box` class as follows?  

```css
.transition-box {
    animation: colorChange 5s 1;
}
```

- a. The box will change colors continuously in a loop.  
- b. The box will change colors once over 5 seconds and then stop.  
- c. The box will immediately become red and stay that way.  
- d. The animation will not work.  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** b. The box will change colors once over 5 seconds and then stop.  

  **Explanation:**  
  The `animation: colorChange 5s 1;` property means that the animation will run for 5 seconds and execute only **once** (`1` iteration). The box will transition through the colors defined in `@keyframes colorChange` and then stop at its final color.  
</details>  