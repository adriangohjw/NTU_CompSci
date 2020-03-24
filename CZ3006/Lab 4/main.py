import numpy as np
import pandas as pd

# state name of file to use
FILENAME = 'test_SFLow_data.csv'

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

print("TOP 5 senders")
senders_grouped = df.groupby('src_IP').size().reset_index(name='Count')
senders_grouped = senders_grouped.sort_values(['Count'], ascending=False)
top5_senders = senders_grouped.head(5)
print(top5_senders)

print("TOP 5 listeners")
listeners_grouped = df.groupby('dst_IP').size().reset_index(name='Count')
listeners_grouped = listeners_grouped.sort_values(['Count'], ascending=False)
top5_listeners = listeners_grouped.head(5)
print(top5_listeners)
