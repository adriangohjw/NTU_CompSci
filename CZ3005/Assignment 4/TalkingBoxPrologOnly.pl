ask(0):-	print("Hey... Do you like "), validate_and_query_options([trekking]).
ask(Y):-
	generate_options(Y,L), validate_and_query_options(L).
generate_options(Y,L):-
	like(Y), print("Great... Do you like "), findnsols(100,X,related(X,Y),L);
	print("Huh... May be you like "), findnsols(100,X,random(X),L).
validate_and_query_options(L):-
	findnsols(100,X,like(X),Likelist), findnsols(100,X,dislike(X),Dislikelist), append(Likelist,Dislikelist,History), list_to_set(L,S), list_to_set(History,H), subtract(S,H,Valid), member(X,Valid), print(X), print('? y/n/q: '), read(Like), (Like==q -> abort;Like==y -> assert(like(X));assert(dislike(X))), ask(X).
	
related(X,Y):- 
	romantic(L),member(X,L),member(Y,L);
	outdoorsy(L),member(X,L),member(Y,L);
	social(L),member(X,L),member(Y,L);
	health_freak(L),member(X,L),member(Y,L);
	loner(L),member(X,L),member(Y,L).

random(X):-
	romantic(A), outdoorsy(B), social(C), health_freak(D), loner(E), append(A,B,AB), append(AB,C,ABC), append(ABC,D,ABCD), append(ABCD,E,ABCDE), random_member(X,ABCDE).

romantic([gifts,wine,dinner,candlelight,rains,tea,concert,night,poetry,music,movie,dating,magic,novels,stories,roses,bouquets,courtship,chickflicks,cruise,breeze,diaries,painting]).
outdoorsy([picnic,trekking,soccer,sports,jogging,kayaking,parks,event,woods,mountains,beaches,cricket,action_movies,dogs,lakes,fairs,swimming,breeze,fitness,water]).
social([coffee,picnic,friends,party,beer,music,concert,event,movie,soccer,dinner,gifts,gardens, roses, flowers,bouquet,cricket,board_games,cafe,netflix,dogs,networking,exhibitions,fairs,debates]).
health_freak([sports,tea,fruitjuice,smoothie,trekking,training,jogging,soccer,sweating,sleeping,swimming,lakes,exercise,burpees,fitness,cats,water,music]).
loner([books,coffee,woods,candlelight,sleeping,training,jogging,night,tea,beaches,poetry,tea,rains,fiction, novels,board_games,netflix,cats,music,painting,sketching,writing,diaries]).

like(nothing).
dislike(nothing).
a.