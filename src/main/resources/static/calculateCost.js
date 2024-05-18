const distances = {
    "CityA-CityB": 200.0,
    "CityA-CityC": 150.0,
    "CityB-CityC": 250.0
};

function calculateBaseCost(weight, dimensions) {
    const baseCostPerKg = 100; // Base cost per kg
    const volumeWeightFactor = dimensions * 0.001; // Convert dimensions to kg equivalent
    const maxWeightOrVolumeWeight = Math.max(weight, volumeWeightFactor);
    return baseCostPerKg + maxWeightOrVolumeWeight;
}

function getDistance(dispatchCity, deliveryCity) {
    const key = `${dispatchCity}-${deliveryCity}`;
    return distances[key] || 0.0; // Use 0.0 if the distance is not defined
}

function calculateAdditionalFees(dispatchCity, deliveryCity) {
    const distanceBetweenCities = getDistance(dispatchCity, deliveryCity);
    return distanceBetweenCities * 0.5; // Additional fees calculation logic
}

function calculateTotalCost() {
    const weight = parseFloat(document.getElementById('weight').value);
    const dimensions = parseFloat(document.getElementById('dimensions').value);
    const dispatchCity = document.getElementById('dispatchCity').value;
    const deliveryCity = document.getElementById('deliveryCity').value;

    const baseCost = calculateBaseCost(weight, dimensions);
    const additionalFees = calculateAdditionalFees(dispatchCity, deliveryCity);
    const totalCost = baseCost + additionalFees;

    // Display the total cost on the page
    document.getElementById('calculated-costs').innerHTML =
        `<p>Base Cost: $${baseCost.toFixed(2)}</p>` +
        `<p>Additional Fees: $${additionalFees.toFixed(2)}</p>` +
        `<p>Total Cost: $${totalCost.toFixed(2)}</p>`;
}
