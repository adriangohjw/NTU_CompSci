#include <stdio.h>

__global__ void vector_dot_product_cu(int *d_c, int *d_a, int *d_b){
	__shared__ int tmp[4];
	int i = threadIdx.x;
	tmp[i] = d_a[i] * d_b[i];

	__syncthreads();

	int sum = 0;
	for (int j = 0; j < 4; j++) {
		sum = sum + tmp[j];
	}
	*d_c = sum;
}

int main(void) {	
	int N = 4;
	int a[N] = { 22, 13, 16, 5 };
	int b[N] = { 5, 22, 17, 37 };
	int c;

	int *d_a, *d_b, *d_c;
	cudaMalloc((void**)&d_a, sizeof(int)*N);
	cudaMalloc((void**)&d_b, sizeof(int)*N);
	cudaMalloc((void**)&d_c, sizeof(int));

	cudaMemcpy(d_a, a, sizeof(int)*N, cudaMemcpyHostToDevice);
	cudaMemcpy(d_b, b, sizeof(int)*N, cudaMemcpyHostToDevice);

	vector_dot_product_cu<<<1,N>>>(d_c, d_a, d_b);
	
	cudaMemcpy(&c, d_c, sizeof(int), cudaMemcpyDeviceToHost);

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

	printf("Answer = %d\n", c);

	return 0;
}
