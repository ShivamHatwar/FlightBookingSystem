import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(flightsList: any, searchText:any): any {
    let newList: any;

    if(searchText){
      newList = flightsList.filter(flight=> flight.source.toLowerCase()
        .startsWith(searchText.toLowerCase()));
  
    }
    else{
      newList = flightsList;
    }

    return newList;
  }
}
