async function selectColor(color) {

    const response = await fetch(`/api/color/${color}`);

    if (!response.ok) {
        alert("Something went wrong");
        return;
    }

    const data = await response.json();

    const colorBox = document.getElementById("colorBox");

    colorBox.style.backgroundColor = data.color;

    colorBox.textContent = `Selected: ${data.color}`;
}