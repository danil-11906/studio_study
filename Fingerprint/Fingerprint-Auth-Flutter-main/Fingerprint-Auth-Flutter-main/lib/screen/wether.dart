import 'package:flutter/material.dart';

import '../point.dart';
import 'home_screen.dart';

class Wether extends StatelessWidget {
  const Wether({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text(
          "Whether",
          style: TextStyle(
              color: Colors.black, fontSize: 20, fontWeight: FontWeight.w600),
        ),
      ),
        floatingActionButton: Column(
          mainAxisAlignment: MainAxisAlignment.end,
          children: <Widget> [
            IconButton(
              onPressed: () async {
                await Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => const HomeScreen()),
                );
              },
              icon: const Icon(Icons.camera_alt),
            ),
            IconButton(
              onPressed: () async {
                await Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => const MyyApp()),
                );
              },
              icon: const Icon(Icons.compass_calibration),
            ),
            IconButton(
              onPressed: () async {
                await Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => const Wether()),
                );
              },
              icon: const Icon(Icons.sunny_snowing),
            )
          ],
        )
    );
  }
}