const path = require('path');
module.exports = {
    webpack: {
        alias: {
            '@vuttr': path.resolve(__dirname, 'src'),
        },
    },
};
