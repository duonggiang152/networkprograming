const API_ENDPOINT = 'http://localhost:3000';
function displayProperties(roomId) {
    // Make an API call to retrieve the properties in the selected room
    fetch(`/rooms/${roomId}/properties`)
        .then(response => response.json())
        .then(properties => {
            console.log(properties)
            // Display the properties on the page
            const propertiesDiv = document.getElementById('properties');
            propertiesDiv.innerHTML = '';
            properties.forEach(property => {
                const propertyDiv = document.createElement('div');
                propertyDiv.innerHTML = `<div class="property">
                <h3>Tên tài sản: ${property.name}</h3>
                <h3>Mã: ${property.id}</h3>
                <p class="price">Giá: ${property.price}</p>
                <p class="price">Phòng: ${property.roomId}</p>
                <p class="price">Loại: ${property.type}</p>
              </div>;`
                propertiesDiv.appendChild(propertyDiv);
            });
        });
}
// Call API to get all rooms
fetch(`${API_ENDPOINT}/rooms`)
    .then(response => response.json())
    .then(rooms => {
        // Get the div where we will display the rooms
        const roomsDiv = document.querySelector('.rooms');

        // Loop through each room and display it
        rooms.forEach(room => {
            // Create a div to display the room
            const roomDiv = document.createElement('div');
            roomDiv.classList.add('room');

            // Add a click event listener to the room div to call the API for the room's properties
            roomDiv.addEventListener('click', () => {
                displayProperties(room.id)
             
            });

            // Create a heading to display the room name
            const heading = document.createElement('h2');
            heading.textContent = "Tên phòng: " + room.name;
            roomDiv.appendChild(heading);

            const id = document.createElement('h3');
            id.textContent = "ID: " + room.id;
            roomDiv.appendChild(id);

            // Create a paragraph to display the room description
            const description = document.createElement('p');
            description.textContent = "Mô tả" + room.descripe;
            roomDiv.appendChild(description);
            // Append the room div to the rooms container
            roomsDiv.appendChild(roomDiv);
        });
    })
    .catch(error => console.error(error));


