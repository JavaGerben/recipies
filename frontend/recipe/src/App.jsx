import { useState, useEffect } from "react";
import "./App.css";
import ShowTitles from "./components/ShowTitles";
import AddTitles from "./components/AddTitles";
import Ingredients from "./components/Ingredients";
import Recipe from "./components/Recipe";
import { Route, Routes } from "react-router-dom";

function App() {
  useEffect(() => {
    getAllRecipes();
  }, []);

  const [recipes, setRecipes] = useState([]);

  const getAllRecipes = async function () {
    await fetch("http://localhost:8080/api/v1/recipes")
      .then((res) => res.json())
      .then((data) => setRecipes(data));
  };

  return (
    <>
      <Routes>
        <Route
          path="/"
          element={
            <>
              <ShowTitles recipes={recipes} />
              <AddTitles />
            </>
          }
        />
        <Route path="/ingredients" element={<Ingredients />} />
        {recipes.map((recipe) => (
          <Route
            key={recipe.id}
            path="/:id"
            element={<Recipe recipe={recipe} />}
          />
        ))}
      </Routes>
    </>
  );
}

export default App;
