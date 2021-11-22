% 5.2
t=-5:0.01:5;
plot(t, square(t))
axis([-5 5 0 3])

% 5.2a
t=-5:0.01:5;
plot(t, square((2*t) + 1))
axis([-5 5 0 3])

% 5.2b
t=-5:0.01:5;
plot(t, 1.5 * square((-6 * t) + 5))
axis([-5 5 0 3])

% 5.2c
t=-5:0.01:5;
a = square(0.5*t -2);
b = 2 * (square((0.5*t)-1));
c = 3 * (square(0.5*t));
d = 2 * (square((0.5*t)+1));
e = square((0.5*t)+2);
plot(t, a + b + c + d + e)
axis([-5 5 -5 6])