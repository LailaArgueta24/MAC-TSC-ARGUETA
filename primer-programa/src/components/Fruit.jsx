const Fruit = ({ fruits }) => {
  return (
    <>
      {fruits.map((fruit, index) => (
        <h3 key={index}>{fruit}</h3>
      ))}
    </>
  );
};

export default Fruit;
