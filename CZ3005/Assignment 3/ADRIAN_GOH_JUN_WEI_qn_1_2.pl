/* relations */
company(sumsum).
company(appy).
competitors(sumsum, appy).
develop(sumsum, galactica-s3).
smartphonetech(galactica-s3).
steal(stevey, galactica-s3).
boss(stevey, appy).

/* rules */
competitors(X, Y):-
	competitors(Y, X).

rival(X, Y):-
	competitors(X, Y).

business(X):-
	smartphonetech(X).

unethical(A):-
	boss(A, B), steal(A, D), business(D), develop(C, D), rival(B, C), company(C).