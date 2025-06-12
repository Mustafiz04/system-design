# Vending Machine System

## Problem Statement
Design and implement a vending machine system that allows users to purchase products by inserting coins, selecting products, and receiving the dispensed product along with any remaining change. The system should handle various states of the vending machine, such as idle, ready, dispensing, and returning change, and ensure proper transitions between these states.

## Requirements
1. **Insert Coins**: Users can insert coins of specific denominations to add balance to the vending machine.
2. **Select Product**: Users can select a product and specify the quantity they want to purchase.
3. **Dispense Product**: The vending machine dispenses the selected product if sufficient balance is available.
4. **Return Change**: Any remaining balance after a transaction is returned to the user.
5. **Cancel Transaction**: Users can cancel the transaction at any time, and the machine will return the inserted balance.
6. **Inventory Management**: The vending machine should maintain an inventory of products and deduct the quantity of products after a successful transaction.
7. **State Management**: The vending machine should transition between different states (Idle, Ready, Dispensing, Returning Change) based on user actions.

## Entities
1. **VendingMachine**: Represents the vending machine and manages its state, balance, inventory, and user interactions.
2. **Product**: Represents a product available in the vending machine, with attributes like name and price.
3. **Inventory**: Manages the stock of products in the vending machine.
4. **Denomination**: Represents the coin denominations that can be inserted into the vending machine.
5. **VendingMachineState**: Interface for defining the behavior of the vending machine in different states.
6. **IdleState**: Represents the state when the vending machine is idle and waiting for user input.
7. **ReadyState**: Represents the state when the vending machine is ready to accept product selection after coins are inserted.
8. **DispensingState**: Represents the state when the vending machine is dispensing the selected product.
9. **ReturnChangeState**: Represents the state when the vending machine is returning the remaining balance to the user.

## Classes

### `VendingMachine`
- Manages the current state, balance, inventory, and user interactions.
- Transitions between states based on user actions.

### `Product`
- **Attributes**:
  - `name`: Name of the product.
  - `price`: Price of the product.

### `Inventory`
- Manages the stock of products.
- **Methods**:
  - `addProduct(Product product, int quantity)`: Adds a product to the inventory.
  - `deductProduct(Product product, int quantity)`: Deducts the specified quantity of a product.

### `Denomination`
- Enum representing coin denominations.
- **Attributes**:
  - `value`: The monetary value of the denomination.

### `VendingMachineState`
- Interface defining methods for state-specific behavior:
  - `insertCoin(VendingMachine vendingMachine, Denomination denomination)`
  - `selectProduct(VendingMachine vendingMachine, Product product, int quantity)`
  - `dispenseProduct(VendingMachine vendingMachine)`
  - `returnChange(VendingMachine vendingMachine)`
  - `cancelTransaction(VendingMachine vendingMachine)`

### `IdleState`
- Implements `VendingMachineState`.
- Represents the idle state of the vending machine.

### `ReadyState`
- Implements `VendingMachineState`.
- Represents the state when the vending machine is ready for product selection.

### `DispensingState`
- Implements `VendingMachineState`.
- Represents the state when the vending machine is dispensing the selected product.

### `ReturnChangeState`
- Implements `VendingMachineState`.
- Represents the state when the vending machine is returning the remaining balance.

### `Main`
- Demonstrates the functionality of the vending machine system with sample interactions.