const generateButton = document.getElementById("generate-btn");
const paletteGrid = document.querySelector(".palette-container");

generateButton.addEventListener("click", createNewPalette);

paletteGrid.addEventListener("click", function (event) {
  if (event.target.classList.contains("copy-btn")) {
    const hexCode = event.target.previousElementSibling.textContent;

    navigator.clipboard
      .writeText(hexCode)
      .then(() => showCopyFeedback(event.target))
      .catch(console.error);

  } else if (event.target.classList.contains("color")) {

    const hexCode = event.target.nextElementSibling
      .querySelector(".hex-value").textContent;

    navigator.clipboard
      .writeText(hexCode)
      .then(() => showCopyFeedback(
        event.target.nextElementSibling.querySelector(".copy-btn")
      ))
      .catch(console.error);
  }
});

function showCopyFeedback(iconElement) {
  iconElement.classList.remove("far", "fa-copy");
  iconElement.classList.add("fas", "fa-check");
  iconElement.style.color = "#48bb78";

  setTimeout(() => {
    iconElement.classList.remove("fas", "fa-check");
    iconElement.classList.add("far", "fa-copy");
    iconElement.style.color = "";
  }, 1500);
}

function createNewPalette() {
  const newColorList = [];

  for (let i = 0; i < 5; i++) {
    newColorList.push(generateHexColor());
  }

  renderPalette(newColorList);
}

function generateHexColor() {
  const hexChars = "0123456789ABCDEF";
  let hexColor = "#";

  for (let i = 0; i < 6; i++) {
    hexColor += hexChars[Math.floor(Math.random() * 16)];
  }

  return hexColor;
}

function renderPalette(colorList) {
  const paletteBoxes = document.querySelectorAll(".color-box");

  paletteBoxes.forEach((box, index) => {
    const colorCode = colorList[index];
    const colorDisplay = box.querySelector(".color");
    const hexLabel = box.querySelector(".hex-value");

    colorDisplay.style.backgroundColor = colorCode;
    hexLabel.textContent = colorCode;
  });
}
