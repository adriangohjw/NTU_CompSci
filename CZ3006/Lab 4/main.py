import numpy as np
import pandas as pd

# state name of file to use
FILENAME = 'SFlow_Data_lab4.csv'

# read from CSV file
matrix = np.genfromtxt(FILENAME, delimiter=',', dtype=None, encoding='utf-8')

# put data into a DataFrame + clean up + add headers
df = pd.DataFrame(data=matrix)
df = df.drop(df.columns[len(df.columns)-1], axis=1)
df.columns = [    
    "Type", "sflow_agent_address", "inputPort", "outputPort", "src_MAC", "dst_MAC",
    "ethernet_type", "in_vlan", "out_vlan", "src_IP", "dst_IP", "IP_protocol", "ip_tos", "ip_ttl", 
    "udp_src_port/tcp_src_port/icmp_type", "udp_dst_port/tcp_dst_port/icmp_code",
    "tcp_flags", "packet_size", "IP_size", "sampling_rate"
]


# EXERCISE 4A: TOP TALKERS AND LISTENERS
print("\nTOP 5 senders")
senders_grouped = df.groupby('src_IP').size().reset_index(name='Count')
senders_grouped = senders_grouped.sort_values(['Count'], ascending=False)
top5_senders = senders_grouped.head(5)
print(top5_senders)

print("\nTOP 5 listeners")
listeners_grouped = df.groupby('dst_IP').size().reset_index(name='Count')
listeners_grouped = listeners_grouped.sort_values(['Count'], ascending=False)
top5_listeners = listeners_grouped.head(5)
print(top5_listeners)


# EXERCISE 4B: TRANSPORT PROTOCOL 
print("\nTransport Protocol Percentage breakdown")
count_row = df.shape[0]
df_grouped = df.groupby('IP_protocol').size().reset_index(name='Count')
df_grouped = df_grouped.sort_values(['Count'], ascending=False)
df_grouped['Percentage'] = df_grouped['Count'] / count_row * 100
top5 = df_grouped.head(5)
print(top5)


# EXERCISE 4C: APPLICATIONS PROTOCOL
print("\nTop 5 frequently used application protocol")
df_grouped = df.groupby('udp_dst_port/tcp_dst_port/icmp_code').size().reset_index(name='Count')
df_grouped = df_grouped.sort_values(['Count'], ascending=False)
top5 = df_grouped.head(10)
print(top5)


# EXERCISE 4D: TRAFFIC INTENSITY
print("\nFinding traffic intensity of the network")
count_row = df.shape[0]
df_packets = df

total_traffic_sampled = df_packets['IP_size'].sum() * 10**-6
print("Total traffic: {} MB". format(total_traffic_sampled))

df_packets['Total_packet_size'] = df_packets['IP_size'] * 1000 * 10**-6
total_traffic = df_packets['Total_packet_size'].sum()
print("Total traffic: {} MB". format(total_traffic))
