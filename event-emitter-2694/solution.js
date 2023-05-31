/**
 * LeetCode problem # 2694, 'Event Emitter'
 * https://leetcode.com/problems/event-emitter/
 */

class EventEmitter {
  constructor() {
    this.subscribers = {};
  }

  subscribe(event, cb) {
    if (!this.subscribers[event]) {
      this.subscribers[event] = [];
    }
    this.subscribers[event].push(cb);

    return {
      unsubscribe: () => {
        this.subscribers[event] = this.subscribers[event].filter(
          (fn) => fn !== cb
        );
      },
    };
  }

  emit(event, args = []) {
    if (!this.subscribers[event]) {
      return [];
    }
    return this.subscribers[event].map((sub) => sub(...args));
  }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */
