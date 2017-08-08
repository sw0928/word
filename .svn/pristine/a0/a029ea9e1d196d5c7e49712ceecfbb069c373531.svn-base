"use strict";


module.exports = function(grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json')
        , tag: {
            banner: '/*!\n'
            + ' * <%= pkg.name %>\n'
            + ' * @version <%= pkg.version %>\n'
            + ' */\n'
        }
        , babel: {
            options: {
                //sourceMap: true
            }
            , dist: {
                files: [
                    {
                        expand: true
                        , cwd: './src'
                        , src: [ '**/*.jsx', '**/*.es6' ]
                        , dest: './lib'
                        , ext: '.js'
                    }
                ]
            }
        }
    })

    grunt.loadNpmTasks('grunt-babel')


    grunt.registerTask('default', ['babel'])

}