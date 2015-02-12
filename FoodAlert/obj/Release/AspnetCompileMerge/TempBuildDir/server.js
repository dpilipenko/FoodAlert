var express = require('express');
var app = express();

app.get('/', function (req, res) {
    res.send('Hi, I am Food Alert. Follow me @_FoodAlert ')
})

app.use(function (req, res, next) {
    res.send(404, 'Stop. It\'s Hammer Time. Take a step, turn around, go back. You aiin\'t wanted here, Jack.');
});

var server = app.listen(process.env.port || 1337, function () {
    var host = server.address().address;
    var port = server.address().port;
    console.log('Example app listening at http://%s:%s', host, port);
});





/*
var http = require('http');
var port = process.env.port || 1337;
http.createServer(function (req, res) {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello World\n');
}).listen(port);
*/

var TwitterBot = require("node-twitterbot").TwitterBot;

// Include your access information below
var Bot = new TwitterBot({
    "consumer_secret": "Os0mwDP9YcFuL8SIgfulijMU5pUzc4zW3aXSi76gQsqSIHcN8q",
    "consumer_key": "nJEapFaQvFpxfn88eqHoeLTvM",
    "access_token": "3031915953-4kfkHm1uAgsfM2h0u91GDthFPTdvfozROoQmFGH",
    "access_token_secret": "GGeyPeI1dMBaebJaqh95HX3Pcb65eGdoqxj4ICKQRJpmy"
});

// Create an action called 'tweet' associated with some function
Bot.addAction("tweet", function (twitter, action, tweet) {
    // Within the action 'tweet', tell the Bot to create a tweet
    Bot.tweet("It is now: " + new Date().toLocaleTimeString());
});

Bot.now("tweet");

/*
// Set up an interval of 2 minutes
//  (2 minutes = 120 seconds = 120000 milliseconds)
setInterval(function () {
    // On every interval, call the 'tweet' action
    Bot.now("tweet");
    // Log a message to the console with the current time
    console.log("Log: Sent a tweet -- " + new Date().toISOString(Date.now()));
}, 20000);
*/