# Gilded Rose Release Notes

## Version 1.1.0 (2025-01-07)

### New Features
- **Support for "Conjured" Items**: Added support for "Conjured" items which degrade in quality twice as fast as normal items.

### Improvements
- **Refactored `updateQuality` Method**: The `updateQuality` method has been refactored for better readability and maintainability. The logic has been broken down into smaller, more focused methods:
    - `updateItemQuality(Item item)`: Updates the quality of an item based on its type.
    - `updateItemSellIn(Item item)`: Decreases the sellIn value of an item, except for "Sulfuras."
    - `handleExpiredItem(Item item)`: Handles the quality degradation for items past their sell-by date.
    - `updateSpecialItemQuality(Item item)`: Updates the quality of special items like "Aged Brie" and "Backstage passes."
    - `isSpecialItem(Item item)`: Checks if an item is a special item like "Aged Brie" or "Backstage passes."
    - `isConjured(Item item)`: Checks if an item is a "Conjured" item.
    - `increaseQuality(Item item)`: Increases the quality of an item, ensuring it does not exceed 50.
    - `decreaseQuality(Item item)`: Decreases the quality of an item, ensuring it does not go below 0.

### Bug Fixes
- **Quality Degradation for "Conjured" Items**: Fixed an issue where "Conjured" items did not degrade in quality twice as fast as normal items after the sell-by date.

### Unit Tests
- **Added Unit Tests**: Added unit tests to cover various item behaviors, including regular items, "Aged Brie," "Sulfuras," "Backstage passes," and "Conjured" items.

## Version 1.0.0
- Initial release of the Gilded Rose.
