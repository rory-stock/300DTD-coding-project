 # Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a game.

This is a simple button-based game where the player can move around a grid of locations, pick up items and use them to
discover other items.
The player can move north, south, east or west, and once they have the correct tools they can unlock new areas and
progress through the game.

### Game Features and Rules

The game has the following features and/or rules:

- The player can move north, south, east or west.
- The player can pick up items.
- The player can use items picked up items to pick up other items.
- The player cannot pick up items if they do not have the correct tools.
- The player cannot finish the game until they have the correct item/s.
  - E.g. need key to unlock door, or sword to escape past guards.
- The player can only move to locations that are adjacent to their current location.
- The player can only have one of each item.

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

- The player can move north, south, east or west.
- The player can pick up items.
- The player can use items picked up items to pick up other items.
- The player cannot repeatedly pick up the same item/can only have one of each item.
- The player cannot pick up items if they do not have the correct tools.
- The player can only move to locations that are adjacent to their current location.
- The player cannot keep moving in a direction if there is no location in that direction.
- The game ends when the player has the correct item/s.
- The player cannot finish the game until they have the correct item/s.

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Move North, South, East, West

- The player can move north, south, east or west.

#### Test Data / Actions to Use

1. Start the game.
2. Move north.
3. Move south.
4. Move east.
5. Move west.

#### Expected Outcome

- Player can move in all directions without issue.


### Pick Up Items

- The player can pick up different items.

#### Test Data / Actions to Use

1. Start the game.
2. Move to a location with an item.
3. Pick up the item.
4. Move to a location with another item.
5. Pick up the item.

#### Expected Outcome

- Player can pick up items without issue.
- Items are removed from the location once picked up.
- Items are added to the player's inventory.


### Use Items to Pick Up Other Items

- Some items require another item to be used in order to pick them up.
- The player can use items picked up items to pick up other items.
- The player cannot pick up items if they do not have the correct tools.

#### Test Data / Actions to Use

1. Start the game.
2. Pick up an item required to pick up another item.
3. Move to a location with an item that requires the first item.
4. Pick up the second item.

#### Expected Outcome

- First item picked up and added to inventory.
- Second item picked up and added to inventory.
- First item removed from inventory.


### Cannot Pick Up Same Item Repeatedly

- The player cannot repeatedly pick up the same item/have multiple of the same item.

#### Test Data / Actions to Use

1. Start the game.
2. Pick up an item.
3. Try to pick up the same item again.

#### Expected Outcome

- First item picked up and added to inventory.
- Player cannot pick up the same item again.


### Cannot pick up item that requires another item without that item

- The player cannot pick up items if they do not have the correct tools.

#### Test Data / Actions to Use

1. Start the game.
2. Move to a location with an item that requires another item.
3. Try to pick up the item.

#### Expected Outcome

- Player cannot pick up the item as they do not have the required item.


### Player can only move to adjacent locations

- The player can only move to locations that are adjacent to their current location.

#### Test Data / Actions to Use

1. Start the game.
2. Move around the map, going back and forth between different locations in different directions.

#### Expected Outcome

- Player can only move to locations that are adjacent to their current location.
- Does not jump to locations that are not adjacent.


### Player cannot keep moving in a direction if there is no location in that direction

- The player cannot keep moving in a direction if there is no location in that direction.

#### Test Data / Actions to Use

1. Start the game.
2. Move to the edge of the map.
3. Try to move in a direction that does not have a location.

#### Expected Outcome

- Player cannot move in a direction that does not have a location.
- Player does not move off the map.
- Player does not move to a location that does not exist.


### Game Ends When Player Has Correct Item/s

- The game ends when the player has the correct item/s.

#### Test Data / Actions to Use

1. Start the game.
2. Move to a location with an item to pick up.
3. Move to another location with an item to pick up that requires the first item.
4. Move to a location that requires the second item to move past.
5. Move past that location.

#### Expected Outcome

- Once player moves past the final location, the game ends and the player wins.


### Player cannot finish the game until they have the correct item/s

- The player cannot finish the game until they have the correct item/s.
- Cannot move past the final location without using the correct item/s.

#### Test Data / Actions to Use

1. Start the game.
2. Move to a final location.
3. Try to move past the final location.

#### Expected Outcome

- Player cannot move past the final location as they do not have the correct item.
- Cannot finish game.

---


## Evidence / Results of Testing

### Move North, South, East, West

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/ETdSuIJDO1BJpV7Mam3B9iQBUnUc9U3AttG6XyttrCFpsA?e=AHCOgr&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

Test went well, player was able to move in all directions without issue.


### Pick Up Items

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/ERhaIEJvugBJggVNYhRu71EBM8ClYcZWtBNXu3GAia5DGA?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=sXAu0K

Test went well, player was able to pick up items without issue. Items were removed from the location and added to the player's inventory.


### Use Items to Pick Up Other Items

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/EfSbkRi5I2dEn27wCGrXJKYBtK5xCHa4rtKa79PIumFQ8A?e=aDvHXY&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

Test went well, player was able to pick up items that required another item to be used in order to pick them up. Initial item was removed from inventory and second item was added.


### Cannot Pick Up Same Item Repeatedly

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/EfXb000JprxForDHWqqU2JcBH_9Ri18KboYWMgS_R8gqEQ?e=ltVepC&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

Test went well, player was unable to pick up the same item repeatedly.


### Cannot pick up item that requires another item without that item

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/EUWeJwZepPVKkVBUVZjKTOQBb62NquY-GJ-EwrPNhlZh8g?e=Ie6VTs&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

Test went well, player was unable to pick up an item that required another item without having that required item.


### Player can only move to adjacent locations

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/EUj_K0TyFGJLnvjazaaRcloBOi8aQPajrlJccQg4CorI6A?e=xYtFyX&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

Test went well, player was only able to move to locations that were adjacent to their current location.


### Player cannot keep moving in a direction if there is no location in that direction

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/EZOgLeNhIetPgJdbA-ViSwQBB9i-sYMB5TBN316D0yucUg?e=HU23MS&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

Test went well, player was unable to move in a direction that did not have a location to move to.


### Game Ends When Player Has Correct Item/s

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/EWwcUJvL-ABKlm-5x0J3QBoBl3E3z3MjJIL7EEvKVDH4iQ?e=2RYaxm&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

Test went well, game ended when player had the correct item/s and moved past the final location.


### Player cannot finish the game until they have the correct item/s

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/rmstock_waimea_school_nz/ERb9DAEG3dhMjDxYvIte2TgBTUCgLZrOicjdD9elqB3dfw?e=N7Rftn&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

Test went well, player was unable to finish the game if they did not have the correct item/s.

---
