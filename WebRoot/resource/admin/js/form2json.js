/*!
  SerializeJSON jQuery plugin.
  https://github.com/jameszhan/form2json
  version 2.4.1 (Oct, 2014)

  Copyright (c) 2014 James Zhan
  Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php)
  and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.
*/

(function (jQuery) {
    "use strict";

    jQuery.fn.extend({
        serializeJSON: function(options) {
            var serializedObject = {},
                opts = jQuery.extend({
                    useIntAsArrayIndex: true,
                    parseNumber: true
                }, options),
                $form = this,
                isObject = function(obj) {
                    var type = typeof obj;
                    return type === "function" || type === "object" && !!obj;
                },
                isSimpleType = function(obj) {
                    var type = typeof obj;
                    return type !== "function" && type !== "object";
                },
                isNumber = function(val) { return /^\d+(\.\d+)?$/.test(val); },
                isUndefined = function(obj) { return obj === void 0; },
                isValidArrayIndex = function(val) { return /^[0-9]+$/.test(String(val));},
                valueFor = function(el) {
                    if (el.value === "on" || el.value === "off") {
                        if ($form.find("input[type=checkbox][name='" + el.name + "']")) {
                            return el.value === "on";
                        } else {
                            return el.value;
                        }
                    } else {
                        return opts.parseNumber && isNumber(el.value) ? +el.value : el.value;
                    }
                },
                doAssign = function(target, keys, value) {
                    var key, nextKey, oldValue, lastIndex, lastValue, currentValue;
                    if (isUndefined(target)) {
                        throw new Error("ArgumentError: param 'target' expected to be an object or array, found undefined");
                    }
                    if (!keys || keys.length === 0) {
                        throw new Error("ArgumentError: param 'keys' expected to be an array with least one element");
                    }
                    key = keys[0];
                    if (keys.length === 1) {
                        if (key === "") {
                            target.push(value);
                        } else {
                            oldValue = target[key];
                            if (oldValue && oldValue.push) { // Handle the same name
                                oldValue.push(value);
                            } else if (oldValue) {
                                target[key] = [ oldValue, value ];
                            } else {
                                target[key] = value;
                            }
                        }
                    } else {
                        nextKey = keys[1];
                        if (key === "") {
                            lastIndex = target.length - 1; //target must be an array
                            lastValue = target[lastIndex];
                            if (isObject(lastValue) && (isUndefined(lastValue[nextKey]) || keys.length > 2)) {
                                key = lastIndex;
                            } else {
                                key = lastIndex + 1;
                            }
                        }
                        currentValue = target[key];
                        if (isUndefined(currentValue)) {
                            target[key] = (nextKey === "" || opts.useIntAsArrayIndex && isValidArrayIndex(nextKey)) ? [] : {};
                        } else if (isSimpleType(currentValue)) {
                            target[key] = opts.useIntAsArrayIndex ? [ currentValue ] : { "": currentValue };
                        }

                        doAssign(target[key], keys.slice(1), value);
                    }
                };

            jQuery.each(this.serializeArray(), function(i, e) {
                var keys;
                if ( e.value && e.name ) {
                    keys = jQuery.map(e.name.split("["), function( key ) { return key.replace(/\]/g, ""); });
                    doAssign( serializedObject, keys, valueFor( e ) );
                }
            });
            return serializedObject;
        }
    });

}(jQuery));
