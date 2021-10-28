//////////////////////////////////////////
// Case: Box Office 2
//////////////////////////////////////////

//1
db.boxofficeExtended.find( {genre:{$size: 2}} )

//2
db.boxofficeExtended.find( {"meta.aired": 2018} )

//3
db.boxofficeExtended.find(
    {$and: [
        {"meta.rating":{$gt:8}},
        {"meta.rating":{$lt:10}}
    ]
} )


//////////////////////////////////////////
// Case: Sports Teams
//////////////////////////////////////////

//1
db.teams.update(
    {title:"Nanyang United"}, 
    {$set:{requiresTeam:true}},
    {upsert:true}
)

db.teams.update(
    {title:"Sengkang One"}, 
    {$set: {requiresTeam:false}},
    {upsert:true}
)

//2
db.teams.updateMany(
    {requiresTeam:true},
    {$set: {minimumPlayers:10}}
)

//3
db.teams.updateMany(
    {requiresTeam:true},
    {$inc: {minimumPlayers:10}}
)


//////////////////////////////////////////
// Case: Persons
//////////////////////////////////////////

db.persons.aggregate(
    [
        {$match:{"dob.age":{$gt:50}}},
        {$group: {
            _id:{groupByGender: "$gender"},
            averageAge:{$avg: "$dob.age"},
            numPerson:{$sum:1}
        }},
        {$sort:{numPersons:-1}}
    ]
)
