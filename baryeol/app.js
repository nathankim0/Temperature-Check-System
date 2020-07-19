/*jslint devel: true */ 
/* eslint-disable no-console */ 
/*eslint no-undef: "error"*/ 
/*eslint-env node*/
//192.168.35.239
//IP주소가 변화하면 안드로이드 앱 내에 있는 url 주소도 바꿔주어야 정상 동작하기시작함!


var express = require('express');
var http = require('http');
var bodyParser= require('body-parser');
var app = express();

app.set('port',process.env.PORT || 3000);
app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());
var router = express.Router();

//첫 번째 미들웨어
app.use(function(req, res, next) {

    console.log('리퀘스트 호출');
    var approve ={'approve_id':'NO'};


    var paramId = req.body.id;
    //var paramPassword = req.body.password;
    console.log('id : '+paramId);

    //아이디 일치여부 flag json 데이터입니다.
    approve.approve_id = paramId;
    //approve.approve_pw = paramPassword;

    res.send('ok');

    var fs = require('fs'); 
    
    fs.appendFile('baryeol.txt', paramId, function (err) {
         if (err) throw err; 
         console.log(paramId); 
        });

});

var server = http.createServer(app).listen(app.get('port'),function(){
   console.log("익스프레스로 웹 서버를 실행함 : "+ app.get('port')); 
});