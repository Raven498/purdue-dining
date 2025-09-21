// Event listener for date input, call API, update next prompt 
// const diningDate = document.getElementById('dining-date');
// const nextBtn = document.getElementById('next-btn');

// nextBtn.addEventListener('click', (e) => {
//     e.preventDefault();
//     console.log("Next button clicked");
//     console.log(diningDate.value);
// })

const IP = "10.184.119.179:8081";

// Get JSON data for that meal, given date, dining hall, meal type
const showDataBtn = document.getElementById('show-data');

showDataBtn.addEventListener('click', (e) => {
    e.preventDefault();
    const diningDate = document.getElementById('dining-date').value;
    const diningLocation = document.getElementById('diningLocation').value;
    const mealType = document.getElementById('mealType').value;

    // Perform validations 
    diningLocation = diningLocation[0].toUpperCase() + diningLocation.slice(1);
    mealType = mealType[0].toUpperCase() + mealType.slice(1);
    if (mealType === "Late-lunch") {
        mealType = "Late Lunch";
    }

    console.log(diningDate, diningLocation, mealType);
    // Call API here 

    // axios.get(`{IP}/availMeals/${}${diningDate}`);

    

})
