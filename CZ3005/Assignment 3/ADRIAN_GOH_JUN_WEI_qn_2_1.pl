/* relations */

queen(queen_elizabeth).
female(queen_elizabeth).

male(prince_charles).
female(princess_ann).
male(prince_andrew).
male(prince_edward).

offspring(prince_charles, queen_elizabeth).
offspring(princess_ann, queen_elizabeth).
offspring(prince_andrew, queen_elizabeth).
offspring(prince_edward, queen_elizabeth).

older(prince_charles, princess_ann).
older(princess_ann, prince_andrew).
older(prince_andrew, prince_edward).


/* rules */

is_older(A, B):-
	older(A, B).
is_older(A, B):-
	older(A, X), is_older(X, B).


% Succession ordering rules
%% Must be offsprings from the same parent
%% Must not be existing queen 

%% Rule 1: Male child will always come before female child
precedes(X, Y):-
	offspring(X, A), offspring(Y, A), 
	male(X), female(Y), 
	not(queen(Y)).

%% Rule 2: Older male child will come before younger male child
precedes(X, Y):-
	offspring(X, A), offspring(Y, A), 
	male(X), male(Y), 
	is_older(X, Y).

%% Rule 3: Older female child will come before younger female child
precedes(X, Y):-	
	offspring(X, A), offspring(Y, A), 
	female(X), female(Y), 
	is_older(X, Y), 
	not(queen(X)), not(queen(Y)).


% Sorting algorithm
sort_succession_list([A|B], SortedList):- 
	sort_succession_list(B, Sorted_Tail), insert(A, Sorted_Tail, SortedList).
sort_succession_list([], []).

insert(A, [B|C], [B|D]):- 
	not(precedes(A,B)), !, insert(A, C, D).
insert(A, C, [A|C]).


% Return succession list
%% Sorted in order of succession ordering
sortedSuccessionList(X, SuccessionList):-
	findall(Y, offspring(Y,X), Offspring), sort_succession_list(Offspring, SuccessionList).
