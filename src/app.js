const express = require('express');

const app = express();
const router = require('./router');

app.get('/', (req, res) => {
    res.json({
        name:'helloo2'
    })
})

app.use(router);

app.listen(5000, '127.0.0.1', () => {
    console.log('server starts');
});
