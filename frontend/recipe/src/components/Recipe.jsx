export default function Recipe(Recipe) {
  const submitAddIngredient = async function () {
    fetch("http://localhost:8080/api/v1/ingredients", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: document.getElementById("addIngredient").value,
      }),
    });
  };

  return Recipe.id;
}
