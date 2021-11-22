% useful reference: https://www.sciencedirect.com/topics/engineering/delta-function

%5.4
%t=-5:0.01:5;
%plot(t, delta(t));

% 5.4a
t=-5:0.01:5;
%plot(t, delta(t));
%hold on;
plot(t, exp(t) .* delta(t-1));

% 5.4b
%expr = (exp(t) .* delta(t-1));
%result = int(expr, t, -100, 100);
%disp(result);

