Requirement:

- CREATE WALLET: 
  - accept the username
  - amount for the wallet
  - Actor is user
- TRANSFER AMOUNT
  - SENDER
  - RECEIVER
  - actor user
- Account Statement
  - ACCOUNT NUMBER
  - statement: current balance and list of transactions
- Overview
  - No other input; Display balance of each account
- Exit
  - Simple to implement. No other input


- Optional Requirements
  - Offer1: this must apply on each transfer mechanism
  - if sender balance and receiver balance are same; add 10 to both
  - Offer2: Whenever this is selected, the top 3 customers with higher number of transactions will get
  - 10, 5,2 R ==> in case of same transaction with high balance ==> then who is older customer

- FIXED_DEPOSIT <fd_amount>
  - Account info
  - an amount = fd_amount is parked for. if after five next transaction, account balance > fd_amount
  - gets 10 as interest
  - and if account balance goes below then dissolve fd

- Display FD amount
  - simple by doing simple change in overview
