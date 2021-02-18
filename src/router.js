const express = require('express');
const router = express.Router();
router.get('/test', (req, res) => {
    res.json({
        list:[
            {
                id:001,
                name:'test'
            }
        ]
    })
})

module.exports = router;