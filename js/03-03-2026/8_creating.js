//creating container

const container = document.createElement("div");
container.style.width="300px";
container.style.height="300px";
container.style.border="2px solid black";
console.log(container);

const h1 = document.createElement("h1");
h1.innerText = "Hello world";
console.log(h1);

container.appendChild(h1);

const button = document.createElement("button");
button.innerText ="click here";

container.appendChild(button);

button.addEventListener("click", () => {
    alert("you hv clicked the button");
});

document.body.appendChild(container);