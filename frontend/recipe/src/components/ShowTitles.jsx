export default function ShowTitles({ recipes }) {
  return (
    <>
      {recipes.map((recipe) => (
        <span key={recipe.id}>
          {recipe.title} <br />
        </span>
      ))}
    </>
  );
}
