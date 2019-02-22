import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}brandFilterManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}brandFilterManager/loadBrandFilter/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateProfile = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}brandFilterManager/requestCandidateProfile/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProfile = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}brandFilterManager/transferToAnotherProfile/id/anotherProfileId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const BrandFilterService = { view,
  load,
  requestCandidateProfile,
  transferToAnotherProfile }
export default BrandFilterService

