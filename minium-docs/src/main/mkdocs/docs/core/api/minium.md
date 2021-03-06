# Minium

* [Web Elements](web-elements.md) - methods for filtering and transversing web 
elements
* [Interactable](interactable.md) - methods for web elements interaction, like
clicking, filling with text
* [Browser](browser.md) - methods for browser manipulation, like opening an URL
* [Configuration](configuration.md) - configure your browser: resize the window,
manage cookies and interaction listeners
* [Assertions](assertions.md) - if you're testing, you better check if things are
as expected (for instance, assert that there is an element with a specific text)
* [Cucumber](cucumber.md) - Minium uses an adapted cucumber-rhino module. In 
this section we describe the differences

## Global Objects

Minium script always provides the following global objects:

* `minium`:
* `browser`: Main browser for minium scripts (it is the same object as
  `minium.browser`)
* `$`: corresponds to the selector function for `browser` (it is the same
  function as `browser.$`)

## Programatic browsers

In case you need more than one browser, it is possible to create them
programatically using function `minium.newBrowser`.

```javascript
var browser2 = minium.newBrowser({
  // for remote webDrivers, you can provide a url:
  // url : "http://localhost:4444/wd/hub",
  desiredCapabilities : {
    browserName : "chrome"
  },
  window : {
    size : { width : 960, height : 1080 },
    position : { x : 0, y : 0 }
  }
});

var $2 = browser2.$;
```

## Modules

### `minium/keys`

```javascript
var keys = require("minium/keys");

// sends Ctrl + Enter to the specified field
$("#some-field").sendKeys(keys.chord([ keys.CONTROL, keys.ENTER ]));
```

### `minium/timeunits`

```javascript
var timeUnits = require("minium/timeunits");

$(":root").waitTime(10, timeUnits.SECONDS);
```

### `minium/offsets`

```javascript
var offsets = require("minium/offsets");

var offset = offsets.at("left+20px center-25%");
$("#some-elem").click(offset);
```