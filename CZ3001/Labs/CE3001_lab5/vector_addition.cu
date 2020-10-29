#include <stdio.h>

__global__ void vector_add_cu(int *d_c, int *d_a, int *d_b, int N){
	int index = (blockIdx.x * blockDim.x) + threadIdx.x;
	d_c[index] = d_a[index] + d_b[index];
}

int main(void) {	
	int N = 4;
	int a[N] = { 22, 13, 16, 5 };
	int b[N] = { 5, 22, 17, 37 };
	int c[N];

	int *d_a, *d_b, *d_c;
	cudaMalloc((void**)&d_a, sizeof(int)*N);
	cudaMalloc((void**)&d_b, sizeof(int)*N);
	cudaMalloc((void**)&d_c, sizeof(int)*N);

	cudaMemcpy(d_a, a, sizeof(int)*N, cudaMemcpyHostToDevice);
	cudaMemcpy(d_b, b, sizeof(int)*N, cudaMemcpyHostToDevice);

	vector_add_cu<<<1,N>>>(d_c, d_a, d_b, N);
	cudaDeviceSynchronize();

	cudaMemcpy(c, d_c, sizeof(int) * N, cudaMemcpyDeviceToHost);

	cudaFree(d_a);
	cudaFree(d_b);

	printf("A ");
	for (int i = 0; i < N; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");

	printf("B ");
	for (int i = 0; i < N; i++) {
		printf("%d ", b[i]);
	}
	printf("\n");	

	printf("C ");
	for (int i = 0; i < N; i++) {
		printf("%d ", c[i]);
	}
	printf("\n");

	return 0;
}
