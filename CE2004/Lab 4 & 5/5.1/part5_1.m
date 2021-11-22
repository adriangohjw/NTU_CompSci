% 5.1
t=-5:0.01:10;
plot(t, step(t))
axis([-5 10 -3 3])

% 5.1a
t=-5:0.01:10;
plot(t, step(t-1))
axis([-5 10 -3 3])

% 5.1b
t=-5:0.01:10;
plot(t, 2*step(t+2))
axis([-5 10 -3 3])

% 5.1c
t=-5:0.01:10;
plot(t, step(t+1)-step(t-1))
axis([-5 10 -3 3])

t=-5:0.01:10;
plot(t, sign(exp(1) - 1/exp(1)))