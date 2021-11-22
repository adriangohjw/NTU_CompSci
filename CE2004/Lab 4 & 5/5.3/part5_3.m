% 5.3
t=-5:0.01:5;
plot(t, ramp_fn(t))
axis([-5 5 -5 5])

% 5.3a
t=-5:0.01:5;
plot(t, ramp_fn(t-1))
axis([-5 5 -5 5])

% 5.3b
t=-5:0.01:5;
plot(t, ramp_fn(t+1))
axis([-5 5 -5 5])

% 5.3c
t=-5:0.01:5;
plot(t, ramp_fn(t+1) - ramp_fn(t-1))
axis([-5 5 -5 5])
