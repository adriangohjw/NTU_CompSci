//1
db.moviestarts.findOne();

//2
db.moviestarts.find({$and:[{"meta.rating":{$gt:9.2}},{"meta.runtime":{$lt:100}}]});

//3
db.moviestarts.find({"genre":{$in:["drama","action"]}});

//4
db.moviestarts.find({"genre":{$all:["drama","action"]}});

//5
db.moviestarts.find({$expr:{$gt:["$visitors","$expectedVisitors"]}});

//6
db.moviestarts.find({"title":{$regex:/Su/}});

//7
db.moviestarts.find({$and:[
    {$or:[
        {"genre":{$all:["action","thriller"]}},
        {"genre":["drama"]}]},
    {"visitors":{$gt:300000}},
    {$and:[
        {"meta.rating":{$gte:8}},
        {"meta.rating":{$lte:9.5}}]}
    ]});
