% Setting up of list methods for appending
append([], Y, Y).
append([H|X], Y, [H|Z]):-
    append(X, Y, Z).


% Facts to check conditions
healthy_meal(healthy).
value_meal(value).
vegan_meal(vegan).
veggie_meal(veggie).
meaty_delight_meal(meaty_delight).


% Possible options for each category
meals([healthy, normal, value, vegan, veggie, meaty_delight]).

vegan_breads([italian_wheat, parmesan_oregano, hearty_italian, multigrain, flatbread]).
non_vegan_breads([honey_oat]).

value_mains([chicken, ham, bacon, tuna]).
expensive_mains([beef, salmon, turkey]).

veggies([cucumber, green_peppers, lettuce, red_onions, tomatoes, olives, jalapenos, pickles]).

healthy_sauces([honey_mustard, sweet_onion, chilli, tomato]).
unhealthy_sauces([chipotle_southwest, bbq, ranch, mayonnaise]).

non_vegan_topups([american, monterey_jack, cheddar, egg_mayonnaise]).
vegan_topups([avocado]).

healthy_sides([cookies, energy_bar]).
unhealthy_sides([chips, hashbrowns]).

healthy_drinks([mineral_water, orange_juice, green_tea, coffee]).
unhealthy_drinks([fountain_drinks]).


% Return a list of all the breads available
breads(X):-
    findall(
        X,
        (vegan_breads(B1), non_vegan_breads(B2), append(B1, B2, X)),
        X
    ).


% Return a list of all the mains available
mains(X):-
    findall(
        X,
        (value_mains(M1), expensive_mains(M2), append(M1, M2, X)),
        X
    ).


% Return a list of all the sauces available
sauces(X):-
    findall(
        X,
        (healthy_sauces(S1), unhealthy_sauces(S2), append(S1, S2, X)),
        X
    ).


% Return a list of all the topups available
topups(X):-
    findall(
        X,
        (non_vegan_topups(T1), vegan_topups(T2), append(T1, T2, X)),
        X
    ).


% Return a list of all the sides available
sides(X):-
    findall(
        X,
        (healthy_sides(S1), unhealthy_sides(S2), append(S1, S2, X)),
        X
    ).


% Return a list of all the drinks available
drinks(X):-
    findall(
        X,
        (healthy_drinks(D1), unhealthy_drinks(D2), append(D1, D2, X)),
        X
    ).

    
% Return a list of possible meals based on previous choices
ask_meals(X):-
    meals(X).


% Return a list of possible breads based on previous choices
% Vegan meals do not have honey oat as an option, return vegan_breads
ask_breads(X):-
    findall(
        X,
        (
            chosen_meals(Y), vegan_meal(Y) -> vegan_breads(X);   
            breads(X)
        ),
        X
    ).


% Return a list of possible mains based on previous choices
% Value meals do not have expensive mains as an option, return value_mains
% Vegan and Veggie meals do not have main options, return empty list [].
ask_mains(X):-
    findall(
        X,
        (
            chosen_meals(Y), \+ vegan_meal(Y), \+ veggie_meal(Y) -> (
                value_meal(Y) -> value_mains(X); 
                mains(X)
            )
        ),
        X
    ).


% Return a list of possible veggies based on previous choices
% Meaty delight meals do not have veggie options, return empty list [].
ask_veggies(X):-
    findall(
        X,
        (chosen_meals(Y), \+ meaty_delight_meal(Y), veggies(X)),
        X
    ).


% Return a list of possible sauces based on previous choices
% Healthy meals do not have unhealthy sauces, return a list containing only healthy_sauces
ask_sauces(X):-
    findall(
        X,
        (
            chosen_meals(Y), healthy_meal(Y) -> healthy_sauces(X);   
            sauces(X)
        ),
        X
    ).


% Return a list of possible top-ups based on previous choices
% Value meal does not have topup, returns an empty list
% Vegan meal does not have non vegan topups, return a list containing vegan_topups
ask_topups(X):-
    findall(
        X,
        (
            chosen_meals(Y), \+ value_meal(Y) -> (
                vegan_meal(Y) -> vegan_topups(X); 
                topups(X)
            )
        ),
        X
    ).


% Return a list of possible sides based on previous choices
% Healthy meals does not have unhealthy sides, return a list containing healthy_sides
ask_sides(X):-
    findall(
        X,
        (
            chosen_meals(Y), healthy_meal(Y) -> healthy_sides(X);   
            sides(X)
        ),
        X
    ).


% Return a list of possible drinks based on previous choices
% Healthy meals does not have unhealthy drinks, return a list containing healthy_drinks
ask_drinks(X):-
    findall(
        X,
        (
            chosen_meals(Y), healthy_meal(Y) -> healthy_drinks(X);   
            drinks(X)
        ),
        X
    ).


% Return a list containing corresponding user choice
show_meals(X):-
    findall(X, chosen_meals(X), X).
show_breads(X):-
    findall(X, chosen_breads(X), X).
show_mains(X):-
    findall(X, chosen_mains(X), X).
show_veggies(X):-
    findall(X, chosen_veggies(X), X).
show_sauces(X):-
    findall(X, chosen_sauces(X), X).
show_topups(X):-
    findall(X, chosen_topups(X), X).
show_sides(X):-
    findall(X, chosen_sides(X), X).
show_drinks(X):-
    findall(X, chosen_drinks(X), X).