const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');

// MySQL database connection
const connection = mysql.createConnection({
  host: 'localhost',
  port: 1502,
  user: 'root',
  password: '123456',
  database: 'managment'
});

// Express app
const app = express();
app.use(bodyParser.json());
app.use(express.static('public'));
// Room routes
app.get('/rooms', (req, res) => {
  connection.query('SELECT * FROM Room WHERE isDelete = false', (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

app.post('/rooms', (req, res) => {
  const room = req.body;
  connection.query('INSERT INTO Room SET ?', room, (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

app.put('/rooms/:id', (req, res) => {
  const roomId = req.params.id;
  const updatedRoom = req.body;
  connection.query('UPDATE Room SET ? WHERE id = ?', [updatedRoom, roomId], (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

app.delete('/rooms/:id', (req, res) => {
  const roomId = req.params.id;
  connection.query('UPDATE Room SET isDelete = true WHERE id = ?', roomId, (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

// Property routes
app.get('/properties', (req, res) => {
  connection.query('SELECT * FROM Property WHERE isDelete = false', (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

app.post('/properties', (req, res) => {
  const property = req.body;
  connection.query('INSERT INTO Property SET ?', property, (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

app.put('/properties/:id', (req, res) => {
  const propertyId = req.params.id;
  const updatedProperty = req.body;
  connection.query('UPDATE Property SET ? WHERE id = ?', [updatedProperty, propertyId], (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

app.delete('/properties/:id', (req, res) => {
  const propertyId = req.params.id;
  connection.query('UPDATE Property SET isDelete = true WHERE id = ?', propertyId, (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

app.get('/rooms/:id/properties', (req, res) => {
    const roomId = req.params.id;
    connection.query('SELECT * FROM Property WHERE roomId = ?', [roomId], (err, results) => {
      if (err) throw err;
      res.json(results);
    });
  });

  app.get('/properties/price-gte-10000000', (req, res) => {
    const query = `SELECT * FROM Property WHERE price >= 10000000`;
    connection.query(query, (error, results) => {
      if (error) {
        console.error(error);
        res.status(500).send('Internal server error');
      } else {
        res.json(results);
      }
    });
  });
// Start the server
app.listen(3000, () => {
  console.log('Server listening on port 3000');
});