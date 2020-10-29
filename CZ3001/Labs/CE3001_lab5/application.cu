#include <stdio.h>

__global__ void vector_calulate_sales_cu(int *d_sales, int *d_hd, int *d_bt, int *d_sp, int *d_td){
	int i = threadIdx.x;
	d_sales[i] = (d_hd[i] * 30) + (d_bt[i] * 15) + (d_sp[i] * 10) + (d_td[i] * 25);
}

int main(void) {	
	int N = 7;
	int hd[N] = { 3, 2, 0, 3, 4, 10, 8 };
	int bt[N] = { 5, 4, 3, 5, 5, 13, 11 };
	int sp[N] = { 2, 5, 3, 4, 5, 21, 15 };
	int td[N] = { 0, 1, 1, 4, 3, 16, 8 };
	int sales[N];

	int *d_hd, *d_bt, *d_sp, *d_td, *d_sales;
	cudaMalloc((void**)&d_hd, sizeof(int)*N);
	cudaMalloc((void**)&d_bt, sizeof(int)*N);
	cudaMalloc((void**)&d_sp, sizeof(int)*N);
	cudaMalloc((void**)&d_td, sizeof(int)*N);
	cudaMalloc((void**)&d_sales, sizeof(int)*N);

	cudaMemcpy(d_hd, hd, sizeof(int)*N, cudaMemcpyHostToDevice);
	cudaMemcpy(d_bt, bt, sizeof(int)*N, cudaMemcpyHostToDevice);
	cudaMemcpy(d_sp, sp, sizeof(int)*N, cudaMemcpyHostToDevice);
	cudaMemcpy(d_td, td, sizeof(int)*N, cudaMemcpyHostToDevice);
	cudaMemcpy(d_sales, sales, sizeof(int)*N, cudaMemcpyHostToDevice);

	vector_calulate_sales_cu<<<1,N>>>(d_sales, d_hd, d_bt, d_sp, d_td);
	
	cudaMemcpy(sales, d_sales, sizeof(int) * N, cudaMemcpyDeviceToHost);

	cudaFree(d_hd);
	cudaFree(d_bt);
	cudaFree(d_sp);
	cudaFree(d_td);

	printf("Sales ");
	for (int i = 0; i < N; i++) {
		printf("%d ", sales[i]);
	}
	printf("\n");	

	return 0;
}
